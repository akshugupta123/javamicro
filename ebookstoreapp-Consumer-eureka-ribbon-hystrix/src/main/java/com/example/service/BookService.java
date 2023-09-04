package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService {
	@Autowired
	private  RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallbackMethodForGetBookById")
	public Book  getBookById(int id) {
		Book book = restTemplate.getForObject("http://book-service/books/" + id, Book.class);
		return book;
		
	}
  public Book fallbackMethodForGetBookById(int id) {
	  
	  return new Book(id, "SampleTitle4", "SamplePublisher4", "1234597890", "300", "2023");

			
  }
}
