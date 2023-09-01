package com.example.show;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String getBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books.jsp";
    }

    @GetMapping("/create")
    public String createBook(@ModelAttribute Book book) {
        return "create.jsp";
    }

    @PostMapping("")
    public String postBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "create.jsp";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }


    @PutMapping("/{id}/edit")
    public String updateBook(@Valid @ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }
        bookService.save(book);
        return "redirect:/books/" + book.id;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}
