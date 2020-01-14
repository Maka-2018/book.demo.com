package com.book.impl;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import com.book.service.BookService;

public class BookRepositoryImpl implements BookRepository{

	private BookService bookService;
		
	public BookService getBookService() {
		return bookService;
	}
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public Book getBook(Integer bookId) {
		
		if (bookId == null || bookId <= 0) {
			throw new IllegalArgumentException("Book Id should be zero "+bookId);
		}
		return this.bookService.retrieveBookDetails(bookId);
	}

}
