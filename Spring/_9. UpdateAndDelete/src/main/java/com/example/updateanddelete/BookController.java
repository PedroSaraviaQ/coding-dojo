package com.example.updateanddelete;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @PostMapping("")
    public Book create(@RequestParam String title, @RequestParam String description,
                       @RequestParam String language, @RequestParam Integer numberOfPages) {
        try {
            Book book = new Book();
            book.setTitle(title);
            book.setDescription(description);
            book.setLanguage(language);
            book.setNumberOfPages(numberOfPages);
            return bookService.save(book);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestParam String title, @RequestParam String description,
                       @RequestParam String language, @RequestParam Integer numberOfPages) {
        Book book = bookService.update(id, title, description, language, numberOfPages);
        return book;
    }

    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
