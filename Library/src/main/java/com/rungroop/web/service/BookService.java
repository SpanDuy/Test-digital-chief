package com.rungroop.web.service;

import com.rungroop.web.models.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();
    Book createBook(Book book);
    Book findBookById(Long bookId);
    void updateBook(Long bookId, Book book);
    void deleteBook(Long bookId);
    Boolean existsById(Long bookId);
}
