package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Book;

@RestController
@Scope("request")
public class BookClientController {

	
	@Autowired
	private  RestTemplate restTemplate;
	
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		
		Book book = restTemplate.getForObject("http://book-service/books/" + id, Book.class);
		return book;
		 
		
	}
}
