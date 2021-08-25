package com.Book.BookStore.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	
	@NotBlank(message = "bookName cannot be blank")
	private String bookName;
	
	@NotBlank(message = "authorName cannot be blank")
	private String authorName;
	
	private double bookPrice;
	
	private String bookDescription;
	
	private int quantityAvailable;
	
}
