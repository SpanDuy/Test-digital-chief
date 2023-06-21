package com.rungroop.web.controller;

import com.rungroop.web.models.Book;
import com.rungroop.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        if (!bookService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Book book = bookService.findBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAllBook();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/post")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (!bookService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        if (!bookService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookService.updateBook(id, book);
        return ResponseEntity.noContent().build();
    }
}
