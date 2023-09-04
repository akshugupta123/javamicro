package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.*;
import com.example.entity.Book;
import com.example.service.BookService;

@RestController
@Scope("request")
public class BookClientController {

	
	@Autowired
	private  BookService bookService;
	
	private Logger log = LoggerFactory.getLogger(BookClientController.class);
	
	
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		
		log.debug("In getBookById with Id: " + id);
		Book book = bookService.getBookById(id);
		log.debug("In getBookById with return value book: " + book);
		return book;
		
	}
}
