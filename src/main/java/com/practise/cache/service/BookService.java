package com.practise.cache.service;

import com.practise.cache.domain.Book;
import com.practise.cache.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);


    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);

    }

    @CachePut(cacheNames = "books",key = "#book.id")
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBook(Integer id) {
        logger.info("Fetching the Book from DB.");
        return bookRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Book Not Found");
        });
    }

    @CacheEvict(cacheNames = "books",key = "#id")
    public String deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return "Book Deleted.";
    }
}
