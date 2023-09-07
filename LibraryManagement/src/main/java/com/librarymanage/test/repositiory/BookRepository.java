package com.librarymanage.test.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanage.test.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
