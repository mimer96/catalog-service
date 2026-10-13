
package com.polarbookshop.catalogservice.services;

import org.springframework.stereotype.Service;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.exceptions.BookAlreadyExistsException;
import com.polarbookshop.catalogservice.exceptions.BookNotFoundException;
import com.polarbookshop.catalogservice.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book addBookToCatalog(Book book) {
        if (bookRepository.existsById(book.isbn())) {
            throw new BookAlreadyExistsException(book.isbn());
        }

        return bookRepository.save(book);
    }

    public Book viewBookDetails(String isbn) {
        return bookRepository.findById(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public void removeBookFromCatalog(String isbn) {
        if (!bookRepository.existsById(isbn)) {
            throw new BookNotFoundException(isbn);
        }

        bookRepository.deleteById(isbn);
    }

    public Book editBookDetails(Book book) {
        if (!bookRepository.existsById(book.isbn())) {
            throw new BookNotFoundException(book.isbn());
        }

        return bookRepository.save(book);
    }
}

