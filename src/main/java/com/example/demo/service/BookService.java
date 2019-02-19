package com.example.demo.service;

import com.example.demo.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Book save(Book book);

    void delete(Book book);

    void deleteAll();

    Book findOne(String id);

    Iterable<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    Page<Book> findByAuthor(String author, Pageable pageable);

    Page<Book> findByTitle(String title, Pageable pageable);
}
