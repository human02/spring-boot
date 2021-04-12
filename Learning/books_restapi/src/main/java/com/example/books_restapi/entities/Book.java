package com.example.books_restapi.entities;

public class Book {
    private int ID;
    private String title;
    private String author;
    private double cost;
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
