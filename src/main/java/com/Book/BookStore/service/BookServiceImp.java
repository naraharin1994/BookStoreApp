package com.Book.BookStore.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Book.BookStore.dto.BookDTO;
import com.Book.BookStore.entity.Book;
import com.Book.BookStore.exception.BookException;
import com.Book.BookStore.repository.BookRepository;

@Service
public class BookServiceImp implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public void addBook(BookDTO bookdto) {
		
		Optional<Book> isBookPresent = bookRepository.findByBookName(bookdto.getBookName());
		
		if(isBookPresent.isPresent()) {
			throw new BookException(HttpStatus.CONFLICT.value(),"Book is already present");
		}
		
		Book book = new Book();
		BeanUtils.copyProperties(bookdto, book);
		bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks(Integer pageNo, Integer pageSize) {

		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Book> pagedResult = bookRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Book>();
		}

	}

	@Override
	public void deleteBook(Long bookId) {
		Optional<Book> isBookIdPresent = bookRepository.findById(bookId);
		
		if(!isBookIdPresent.isPresent()) {
			throw new BookException(HttpStatus.BAD_REQUEST.value(), "Invalid BookId");
		}
		bookRepository.deleteById(bookId);;
	}

	@Override
	public void updateBook(BookDTO bookdto, Long bookId) {
		
		Optional<Book> isBookPresent = bookRepository.findById(bookId);
		
		if(!isBookPresent.isPresent()) {
			throw new BookException(HttpStatus.BAD_REQUEST.value(), "Invalid BookId");
		}
		
		Book existingBook =  bookRepository.findById(bookId).get();
		BeanUtils.copyProperties(bookdto, existingBook);
		bookRepository.save(existingBook);
		
	}



	
}