package com.hs;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private int publicationYear;
	private boolean available;

	public Book(String isbn, String title, String author, int publicationYear) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.available = true;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isAvailable() {
		return available;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}