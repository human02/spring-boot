package com.example.books_restapi.dao;

import com.example.books_restapi.entities.Book;

import org.springframework.data.repository.CrudRepository;

// Its important to defien the CrudRepository as it is a generic type.
// Book is the type of data which is to be handled
// Integer is the type of the ID 
public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
