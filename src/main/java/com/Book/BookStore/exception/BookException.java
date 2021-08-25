package com.Book.BookStore.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookException extends RuntimeException {
	
	private int statusCode;
	
	private String statusMessage;
}
