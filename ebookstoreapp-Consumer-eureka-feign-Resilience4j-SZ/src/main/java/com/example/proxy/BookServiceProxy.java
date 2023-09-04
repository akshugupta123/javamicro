package com.example.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Book;
//import com.example.fallback.BookServiceFallback;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;




@FeignClient(name = "book-service")
public interface BookServiceProxy {

	@Retry(name = "book-service")
	@CircuitBreaker(name= "book-service", fallbackMethod = "fallbackMethodGetBookById")
	@GetMapping(value="/books/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Book getBookById(@PathVariable("id") Integer id);
	
	
	@CircuitBreaker(name= "book-service", fallbackMethod = "fallbackMethodGetAllBooks")
	@GetMapping(value="/books", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getAllBooks();
	
	
	public default Book fallbackMethodGetBookById(Integer id, Throwable cause) {
		
		System.out.println("Exception raised message with:========>" + cause.getMessage());
		return new Book(id,"SampleTitle5", "SamplePublisher5", "1234567790", "500", "2062");
	}

	
	public default List<Book> fallbackMethodGetAllBooks(Throwable cause) {
		System.out.println("Exception raised message with:========>" + cause.getMessage());
		return new ArrayList<Book>();
	}
	
}
