package com.example.books_restapi.services;

import java.util.List;

import com.example.books_restapi.dao.BookRepository;
import com.example.books_restapi.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // it tells the spring boot that its object need to be created where autowired
           // is mentioned. @service can also be used
public class BookService {

    // now using actual database
    @Autowired
    private BookRepository bookRepository;

    // // this in ideal case will be interacting with the DAO layer.
    // // We are creating here a fake database below.
    // static private List<Book> booksList = new ArrayList<>();
    // // this code block wil run automatically when class is loaded.
    // static {
    // booksList.add(new Book(11, "head first java", "1", 11.00, 2020));
    // booksList.add(new Book(12, "head first golang", "2", 11.00, 2018));
    // booksList.add(new Book(13, "head first python", "3", 11.00, 2019));
    // }

    // get all books
    public List<Book> getAllBooks() {
        // originally iterable was returned but as it is the parent class hence itcan be
        // type casted to list.
        return (List<Book>) this.bookRepository.findAll();
        // return booksList;
    }

    // get book by Id
    public Book getBookByID(int ID) {
        Book book = null;
        try {
            book = this.bookRepository.findById(ID);
            // book = (Book) booksList.stream().filter(e -> e.getID() ==
            // ID).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // adds a book to the database(here it is a list).
    public Book addBook(Book b) {
        Book added = this.bookRepository.save(b);
        // return booksList.add(b);
        return added;

    }

    // delete book by ID
    public void deleteBookByID(int ID) {
        // foreach loop logic could have been used but I used streams instead.
        // here we are overwriting the existing list by removing the object with
        // matching ID.
        // int n = booksList.size();
        // booksList = booksList.stream().filter(e -> e.getID() !=
        // ID).collect(Collectors.toList());
        // if (n == booksList.size()) {
        // return false;
        // }
        // return true;
        // }

        this.bookRepository.deleteById(ID);

    }

    // update book
    public void updateBookByID(int ID, Book b) {
        Book originalBook = this.bookRepository.findById(ID);
        Book updateBook = new Book();
        updateBook = originalBook;
        updateBook.setTitle(b.getTitle());
        updateBook.setAuthor(b.getAuthor());
        updateBook.setCost(b.getCost());
        updateBook.setYear(b.getYear());

        this.bookRepository.save(updateBook);

        // // Map applies the anonymous function to every element.
        // booksList.stream().map(e -> {
        // if (e.getID() == ID) {
        // e.setTitle(b.getTitle());
        // e.setAuthor(b.getAuthor());
        // e.setCost(b.getCost());
        // e.setYear(b.getYear());
        // }
        // return e;
        // }).collect(Collectors.toList());// this collects and converts to list.

    }

    // booksList = booksList.stream().filter(e -> e.getID() !=
    // ID).collect(Collectors.toList());
    // booksList.add(b);
    // return (Book) booksList.stream().filter(e -> e.getID() ==
    // ID).findFirst().get();
    public void deleteAll() {
        this.bookRepository.deleteAll();
    }
}
