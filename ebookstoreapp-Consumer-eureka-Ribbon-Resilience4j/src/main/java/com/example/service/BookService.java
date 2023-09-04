package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Book;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@Service
public class BookService {
	@Autowired
	private  RestTemplate restTemplate;
	
	@Retry(name = "book-service")
	@CircuitBreaker(name="book-service", fallbackMethod = "fallbackMethodForGetBookById")
	public Book  getBookById(int id) {
		Book book = restTemplate.getForObject("http://book-service/books/" + id, Book.class);
		return book;
		
	}
  public Book fallbackMethodForGetBookById(int id, Throwable cause) {
	  
	  System.out.println("Exception Rasied with the message:======> " + cause.getMessage());
	  return new Book(id, "SampleTitle4", "SamplePublisher4", "1234597890", "300", "2023");

			
  }
}
