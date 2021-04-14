package com.example.books_restapi.controllers;

import java.util.List;
import java.util.Optional;

import com.example.books_restapi.entities.Book;
import com.example.books_restapi.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController // This is required for JSON data return
// @Controller // Denotes that this is the controller class. Data not in JSON
// format.
public class TestController {

    // In order to make auto object of BookService class, do the following (include
    // proper naming convention)
    @Autowired
    private BookService bookService;

    @GetMapping("/test") // smaller version of the below statement.
    // @RequestMapping(value = "/test", method = RequestMethod.GET) // This is the
    // same as the dealration below.
    // @RequestMapping("/test") // Used for mapping this request to this method.
    // @ResponseBody // return the srting as HTML.

    public Book test() {

        // to get a JSON response
        Book book = new Book();
        book.setTitle("Spring");
        book.setAuthor("first");
        book.setYear(2021);
        book.setCost(10.00);

        return book;
        // return ("Hi test is a success - " + (50 + 16));
    }

    // Get all books handler
    @GetMapping("/books")
    // Response Entity is used to send correct status code.
    public ResponseEntity<List<Book>> books() {
        // In order to use the class and its function, we have to create it object
        // manually which is cumbersome. Like stated below:
        // BookService bookService = new BookService();

        List<Book> l = this.bookService.getAllBooks();
        if (l.size() <= 0) {
            System.out.println("\nNo Books Found\n");
            // status - is a static method of Response Entity
            // build - is neccessary to build new object
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // this is how 'l' list is sent in response entity.
        return ResponseEntity.of(Optional.of(l));

    }

    // Single book handler
    @GetMapping("/book/{n}") // n is the input
    public ResponseEntity<Book> SingleBook(@PathVariable("n") int id) {
        // BookService bookService = new BookService();

        Book b = this.bookService.getBookByID(id);

        if (b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

    @PostMapping("/book")
    // put the return type of the service function like 'boolean' mentioned below
    public ResponseEntity<Boolean> addSingleBook(@RequestBody Book b) {
        try {
            this.bookService.addBook(b);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    // delete handler
    @DeleteMapping("/book/{bookID}")
    // '?' can be used for generic, 'Void' can be used fro void return types.
    public ResponseEntity<?> deleteBook(@PathVariable("bookID") int ID) {
        if (ID == -1) {
            try {

                this.bookService.deleteAll();
                return ResponseEntity.status(HttpStatus.OK).build();

            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            try {
                if (this.bookService.getBookByID(ID) == null) {
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                }
                this.bookService.deleteBookByID(ID);

                return ResponseEntity.ok().build();

            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }

    // update handler
    @PutMapping(value = "book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Book b) {
        try {
            this.bookService.updateBookByID(id, b);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
