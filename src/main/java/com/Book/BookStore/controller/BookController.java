package com.Book.BookStore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Book.BookStore.dto.BookDTO;
import com.Book.BookStore.entity.Book;
import com.Book.BookStore.repository.BookRepository;
import com.Book.BookStore.response.Response;
import com.Book.BookStore.service.BookService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value="/bookStore",produces= MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/books")
	@ApiOperation(value = "Api to add book",response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201,message = "Book added successfully"),
			@ApiResponse(code = 422,message = "Request body is not valid")
	})
	public ResponseEntity<Response> addBook(@Valid @RequestBody BookDTO bookdto,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Response>(new Response(HttpStatus.UNPROCESSABLE_ENTITY.value(), bindingResult.getAllErrors().get(0).getDefaultMessage(), ""),HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		bookService.addBook(bookdto);
		return new ResponseEntity<Response>(new Response(HttpStatus.CREATED.value(), "SUCCESS", ""), HttpStatus.CREATED);
	}
	
	@GetMapping
	@ApiOperation(value = "Api to get all book details",response = Response.class)
	public ResponseEntity<Response> getAllBooks(
			 @RequestParam(defaultValue = "0") Integer pageNo, 
             @RequestParam(defaultValue = "10") Integer pageSize
            ) {
		
		List<Book> books = bookService.getAllBooks(pageSize, pageSize);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "SUCCESS", books), HttpStatus.OK);
	}
	
	@DeleteMapping("books/")
	public ResponseEntity<Response> deleteBook(@Valid @RequestParam() Long bookId){
		
		bookService.deleteBook(bookId);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Book is deleted Successfully", ""), HttpStatus.OK);
	}
	
	@PutMapping("books/")
	public ResponseEntity<Response> updateBook(@Valid @RequestBody BookDTO bookdto,BindingResult bindingResult,
			@RequestParam() Long bookId){
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Response>(new Response(HttpStatus.UNPROCESSABLE_ENTITY.value(), bindingResult.getAllErrors().get(0).getDefaultMessage(), ""),HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		bookService.updateBook(bookdto,bookId);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Book is updated Successfully", ""), HttpStatus.OK);
	}

}
