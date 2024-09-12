package com.hs;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private final String id;
	private final String name;
	private final String contactInfo;
	private final List<Book> borrowedBooks;

	public Member(String id, String name, String contactInfo) {
		this.id = id;
		this.name = name;
		this.contactInfo = contactInfo;
		this.borrowedBooks = new ArrayList<>();
	}

	public void borrowBook(Book book) {
		borrowedBooks.add(book);
	}

	public void returnBook(Book book) {
		borrowedBooks.remove(book);
	}

	public String getId() {
		return id;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public String getName() {
		return name;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
}