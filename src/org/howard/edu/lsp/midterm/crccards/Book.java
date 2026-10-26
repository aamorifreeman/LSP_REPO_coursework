package org.howard.edu.lsp.midterm.crccards;

/**
 * A book whose lending state is controlled through borrow and return operations.
 * @author Aamori Freeman (with disclosed OpenAI Codex assistance)
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private boolean available = true;

    /**
     * Creates an available book.
     * @param isbn the book identifier
     * @param title the book title
     * @param author the author's name
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    /** @return this book's ISBN */
    public String getIsbn() { return isbn; }

    /** @return this book's title */
    public String getTitle() { return title; }

    /** @return this book's author */
    public String getAuthor() { return author; }

    /** @return true when this book is available to borrow */
    public boolean isAvailable() { return available; }

    /**
     * Borrows this book.
     * @throws IllegalStateException if the book is already borrowed
     */
    public void borrowBook() {
        if (!available) {
            throw new IllegalStateException("Book is already borrowed: " + isbn);
        }
        available = false;
    }

    /**
     * Returns this book.
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook() {
        if (available) {
            throw new IllegalStateException("Book is already available: " + isbn);
        }
        available = true;
    }

    /** @return the ISBN, title, author, and availability in the required format */
    @Override
    public String toString() {
        return isbn + " " + title + " by " + author
                + (available ? " [AVAILABLE]" : " [BORROWED]");
    }
}
