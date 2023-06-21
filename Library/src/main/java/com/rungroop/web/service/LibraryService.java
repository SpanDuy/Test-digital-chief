package com.rungroop.web.service;


import com.rungroop.web.models.Library;

import java.util.List;

public interface LibraryService {
    List<Library> findAllLibrary();
    Library createLibrary(Library library);
    Library findLibraryById(Long libraryId);
    void updateLibrary(Long libraryId, Library library);
    void deleteLibrary(Long libraryId);
    Boolean existsById(Long bookId);
}
