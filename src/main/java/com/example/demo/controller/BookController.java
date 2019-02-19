package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Page<Book> index(Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable String id) {
        return bookService.findOne(id);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable String id) {
        book.setId(id);
        return bookService.save(book);
    }

    @GetMapping("/search")
    public Page<Book> searchByTitle(@RequestParam String title, Pageable pageable) {
        return bookService.findByTitle(title, pageable);
    }

    @DeleteMapping
    public void delete() {
        bookService.deleteAll();
    }
}
