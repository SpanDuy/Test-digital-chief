package com.rungroop.web.service.impl;

import com.rungroop.web.models.Book;
import com.rungroop.web.models.Library;
import com.rungroop.web.repository.BookRepository;
import com.rungroop.web.repository.LibraryRepository;
import com.rungroop.web.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {
    private LibraryRepository libraryRepository;
    private BookRepository bookRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Library> findAllLibrary() {
        List<Library> libraries = libraryRepository.findAll();
        return libraries;
    }

    @Override
    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library findLibraryById(Long libraryId) {
        Library library = libraryRepository.findById(libraryId).get();
        return library;
    }

    @Override
    public void updateLibrary(Long libraryId, Library library) {
        Library updatedlibrary = libraryRepository.findById(libraryId).get();

        updatedlibrary.setName(library.getName());
        updatedlibrary.setAddress(library.getAddress());
        updatedlibrary.setPhone(library.getPhone());
        updatedlibrary.setWorkingHours(library.getWorkingHours());
        updatedlibrary.setBookCount(library.getBookCount());
        updatedlibrary.setBooks(library.getBooks());

        libraryRepository.save(updatedlibrary);
    }

    @Override
    public void deleteLibrary(Long libraryId) {
        libraryRepository.deleteById(libraryId);
    }

    @Override
    public Boolean existsById(Long libraryId) {
        return libraryRepository.existsById(libraryId);
    }
}
