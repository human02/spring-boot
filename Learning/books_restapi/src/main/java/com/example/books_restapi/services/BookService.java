package com.example.books_restapi.services;

import java.util.ArrayList;
import java.util.List;

import com.example.books_restapi.entities.Book;

import org.springframework.stereotype.Component;

@Component // it tells the spring boot that its object need to be created where autowired
           // is mentioned. @service can also be used
public class BookService {
    // this in ideal case will be interacting with the DAO layer.

    // We are creating here a fake database below.
    static private List<Book> booksList = new ArrayList<>();
    // this code block wil run automatically when class is loaded.
    static {
        booksList.add(new Book(11, "head first java", "1", 11.00, 2020));
        booksList.add(new Book(12, "head first golang", "2", 11.00, 2018));
        booksList.add(new Book(13, "head first python", "3", 11.00, 2019));
    }

    // get all books
    public List<Book> getAllBooks() {
        return booksList;
    }

    // get book by Id
    public Book getBookByID(int ID) {
        Book book = null;
        book = (Book) booksList.stream().filter(e -> e.getID() == ID).findFirst().get();
        return book;
    }
}
