package com.rungroop.web.controller;

import com.rungroop.web.models.Book;
import com.rungroop.web.models.Library;
import com.rungroop.web.service.BookService;
import com.rungroop.web.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    private LibraryService libraryService;
    private BookService bookService;

    @Autowired
    public LibraryController(LibraryService libraryService, BookService bookService) {
        this.libraryService = libraryService;
        this.bookService = bookService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Library> getLibrary(@PathVariable("id") Long id) {
        if (!libraryService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Library library = libraryService.findLibraryById(id);
        return ResponseEntity.ok(library);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Library>> getAllLibraries() {
        List<Library> libraries = libraryService.findAllLibrary();
        return ResponseEntity.ok(libraries);
    }

    @PostMapping("/post")
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        Library savedLibrary = libraryService.createLibrary(library);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLibrary);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        if (!libraryService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Void> updateLibrary(@PathVariable("id") Long id, @RequestBody Library library) {
        if (!libraryService.existsById(id).booleanValue()) {
            return ResponseEntity.notFound().build();
        }
        libraryService.updateLibrary(id, library);
        return ResponseEntity.noContent().build();
    }
}
