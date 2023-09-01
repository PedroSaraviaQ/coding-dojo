package com.example.show;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }

    public Book update(Long id, String title, String description, String language, Integer numberOfPages) {
        Optional<Book> opBook = bookRepository.findById(id);
        if (opBook.isPresent()) {
            Book book = opBook.get();
            book.setTitle(title);
            book.setDescription(description);
            book.setLanguage(language);
            book.setNumberOfPages(numberOfPages);
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
