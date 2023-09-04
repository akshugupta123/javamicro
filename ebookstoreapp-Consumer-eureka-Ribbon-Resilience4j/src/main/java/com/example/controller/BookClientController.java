package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Book;
import com.example.service.BookService;

@RestController
@Scope("request")
public class BookClientController {

	
	@Autowired
	private  BookService bookService;
	
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		
		return bookService.getBookById(id);
		
	}
}
