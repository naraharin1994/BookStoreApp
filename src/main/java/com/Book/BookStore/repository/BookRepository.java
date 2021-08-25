package com.Book.BookStore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Book.BookStore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	public Optional<Book> findByBookName(String bookName);
}
