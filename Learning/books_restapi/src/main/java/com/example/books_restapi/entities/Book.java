package com.example.books_restapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// hibernate configuration
@Entity
@Table(name = "books") // this will be the table name created in the database.
public class Book {
    @Id // makes it the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // it auto increases the Id.
    @Column(name = "Book_ID") // used to change the name of to the parameter.
    private int ID;

    @Column(name = "Book_Title")
    private String title;
    @Column(name = "Author")
    private String author;
    @Column(name = "Price")
    private double cost;
    @Column(name = "Publication_Year")
    private int year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Book() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Book(int iD, String title, String author, double cost, int year) {
        ID = iD;
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book [ID=" + ID + ", author=" + author + ", cost=" + cost + ", title=" + title + ", year=" + year + "]";
    }

}
