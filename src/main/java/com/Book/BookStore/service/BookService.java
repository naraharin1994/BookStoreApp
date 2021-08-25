package com.Book.BookStore.service;

import java.util.List;

import com.Book.BookStore.dto.BookDTO;
import com.Book.BookStore.entity.Book;

public interface BookService {
	
	public void addBook(BookDTO bookdto);
	
	public List<Book> getAllBooks(Integer pageNo, Integer pageSize);
	
	public void deleteBook(Long bookId);
	
	public void updateBook(BookDTO bookdto,Long bookId);
}
