package com.practise.cache.controller;

import com.practise.cache.domain.Book;
import com.practise.cache.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }


    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        return bookService.getBook(id);
    }

}
