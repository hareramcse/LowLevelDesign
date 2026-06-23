package com.hs;

public class LibraryManagementSystemTest {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        library.addBook(new Book("ISBN1", "Book 1", "Author 1"));
        library.addBook(new Book("ISBN2", "Book 2", "Author 2"));
        library.addBook(new Book("ISBN3", "Book 3", "Author 3"));

        library.registerMember(new Member("M1", "John Doe"));
        library.registerMember(new Member("M2", "Jane Smith"));

        library.borrowBook("M1", "ISBN1");
        library.borrowBook("M2", "ISBN2");
        library.returnBook("M1", "ISBN1");

        System.out.println("Search Results:");
        library.searchBooks("Book").forEach(b ->
                System.out.println(b.title() + " by " + b.author()));
    }
}
