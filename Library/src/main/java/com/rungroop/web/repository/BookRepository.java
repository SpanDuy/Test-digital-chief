package com.rungroop.web.repository;

import com.rungroop.web.models.Book;
import com.rungroop.web.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>  {
}
