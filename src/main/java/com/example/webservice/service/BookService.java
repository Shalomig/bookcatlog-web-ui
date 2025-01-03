

package com.example.webservice.service;

import com.example.webservice.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private final Map<Long, Book> bookRepository = new HashMap<>();
    private Long idCounter = 1L;

    public Book addBook(Book book) {
        book.setId(idCounter++);
        bookRepository.put(book.getId(), book);
        return book;
    }

    public Book getBookById(Long id) {
        return bookRepository.get(id); // Returns the book with the specified ID or null if not found.
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.values();
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepository.containsKey(id)) {
            book.setId(id);
            bookRepository.put(id, book);
            return book;
        }
        return null;
    }

    public boolean deleteBook(Long id) {
        return bookRepository.remove(id) != null;
    }
}








