package com.hs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManager {
    private final Map<String, Book> catalog = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private static final int MAX_BOOKS = 5;

    public void addBook(Book book) {
        catalog.put(book.isbn(), book);
    }

    public void registerMember(Member member) {
        members.put(member.id(), member);
    }

    public void borrowBook(String memberId, String isbn) {
        Member member = members.get(memberId);
        Book book = catalog.get(isbn);
        if (member == null || book == null || !book.isAvailable()) {
            System.out.println("Cannot borrow book.");
            return;
        }
        if (member.borrowed().size() >= MAX_BOOKS) {
            System.out.println(member.name() + " reached borrow limit.");
            return;
        }
        member.borrowed().add(book);
        book.setAvailable(false);
        System.out.println("Borrowed: " + book.title() + " by " + member.name());
    }

    public void returnBook(String memberId, String isbn) {
        Member member = members.get(memberId);
        Book book = catalog.get(isbn);
        if (member == null || book == null) {
            System.out.println("Cannot return book.");
            return;
        }
        member.borrowed().remove(book);
        book.setAvailable(true);
        System.out.println("Returned: " + book.title() + " by " + member.name());
    }

    public List<Book> searchBooks(String keyword) {
        return catalog.values().stream()
                .filter(b -> b.title().contains(keyword) || b.author().contains(keyword))
                .toList();
    }
}
