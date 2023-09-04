package com.example.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Book;
import com.example.proxy.BookServiceProxy;

@Component
public class BookServiceFallback implements BookServiceProxy{

	@Override
	public Book getBookById(Integer id) {
		
		return new Book(id,"SampleTitle5", "SamplePublisher5", "1234567790", "500", "2062");
	}

	@Override
	public List<Book> getAllBooks() {
		
		return new ArrayList<Book>();
	}

}
