package com.rungroop.web.service.impl;

import com.rungroop.web.models.Book;
import com.rungroop.web.repository.BookRepository;
import com.rungroop.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBook() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).get();
        return book;
    }

    @Override
    public void updateBook(Long bookId, Book book) {
        Book updatedBook = bookRepository.getById(bookId);

        updatedBook.setTitle(book.getTitle());
        updatedBook.setGenre(book.getGenre());
        updatedBook.setYear(book.getYear());
        updatedBook.setPageCount(book.getPageCount());
        updatedBook.setIsbn(book.getIsbn());

        bookRepository.save(updatedBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Boolean existsById(Long bookId) {
        return bookRepository.existsById(bookId);
    }
}
