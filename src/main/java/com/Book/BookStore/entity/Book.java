package com.Book.BookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	
	@Column(nullable = false,unique = true)
	private String bookName;
	
	@Column(nullable = false,unique = true)
	private String authorName;
	
	private double bookPrice;
	
	private String bookDescription;
	
	private int quantityAvailable;

}
