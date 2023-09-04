package com.example.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.proxy.BookServiceProxy;

@RestController
@Scope("request")
public class BookClientController {
 
	
	@Autowired
	private BookServiceProxy bookServiceProxy;
	
	private Logger log = LoggerFactory.getLogger(BookClientController.class);
	
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id") int id ) {
	
		
		log.debug("In getBookById with Id: " + id);
		Book book = bookServiceProxy.getBookById(id);
		log.debug("In getBookById with return value book: " + book);
		return book;
	
	}
	
	@GetMapping("/get-books")
	public List<Book> getAllBooks() {
		
	List<Book> books = bookServiceProxy.getAllBooks();
	log.debug("In getBookById with return value books: " + books);
		return books;
	}
	
}
