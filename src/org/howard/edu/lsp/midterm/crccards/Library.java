package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Stores books by ISBN and coordinates lending with a three-book library limit.
 * Books in this library must be borrowed and returned through this class.
 * @author Aamori Freeman (with disclosed OpenAI Codex assistance)
 */
public class Library {
    private static final int BORROWING_LIMIT = 3;
    private final Map<String, Book> books = new HashMap<>();

    /** Creates an empty library. */
    public Library() { }

    /**
     * Adds a book without replacing any existing book with the same ISBN.
     * @param book the book to add
     * @throws IllegalArgumentException if the book is null or its ISBN exists
     * @throws IllegalStateException if adding a borrowed book would exceed the limit
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Duplicate ISBN: " + book.getIsbn());
        }
        // Preserve the library limit even if an already borrowed book is added.
        if (!book.isAvailable() && getBorrowedBookCount() >= BORROWING_LIMIT) {
            throw new IllegalStateException("Library borrowing limit reached");
        }
        books.put(book.getIsbn(), book);
    }

    /**
     * Looks up a book without changing it.
     * @param isbn the ISBN to find
     * @return the stored instance, or null if absent
     */
    public Book findBook(String isbn) { return books.get(isbn); }

    /**
     * Borrows an existing book when the library has capacity.
     * @param isbn the ISBN to borrow
     * @throws IllegalArgumentException if the ISBN is absent
     * @throws IllegalStateException if already borrowed or the limit is reached
     */
    public void borrowBook(String isbn) {
        Book book = requireBook(isbn);
        if (getBorrowedBookCount() >= BORROWING_LIMIT) {
            throw new IllegalStateException("Library borrowing limit reached");
        }
        book.borrowBook();
    }

    /**
     * Returns an existing book by delegating its state transition to the book.
     * @param isbn the ISBN to return
     * @throws IllegalArgumentException if the ISBN is absent
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook(String isbn) { requireBook(isbn).returnBook(); }

    /** @return a new list of available books, empty if none are available */
    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) { result.add(book); }
        }
        return result;
    }

    /**
     * Finds books by an exact, case-sensitive author match, including loans.
     * @param author the author to match
     * @return a new list of matching books, empty if there are no matches
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (Objects.equals(author, book.getAuthor())) { result.add(book); }
        }
        return result;
    }

    /** @return a new list of all books in ascending lexicographical ISBN order */
    public List<Book> getBooksSortedByIsbn() {
        List<Book> result = new ArrayList<>(books.values());
        result.sort(Comparator.comparing(Book::getIsbn));
        return result;
    }

    /** @return the current number of borrowed books in this library */
    public int getBorrowedBookCount() {
        int count = 0;
        for (Book book : books.values()) {
            if (!book.isAvailable()) { count++; }
        }
        return count;
    }

    private Book requireBook(String isbn) {
        Book book = findBook(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Unknown ISBN: " + isbn);
        }
        return book;
    }
}
