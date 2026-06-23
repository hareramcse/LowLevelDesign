package com.hs;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private boolean available = true;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String isbn() { return isbn; }
    public String title() { return title; }
    public String author() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
