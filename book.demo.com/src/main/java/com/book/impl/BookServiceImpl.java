package com.book.impl;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import com.book.service.BookService;

public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;
	
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book retrieveBookDetails(Integer bookId) {
		
		if (bookId <= 0 || bookId == null) {
			throw new IllegalArgumentException("Book Id should not be none "+bookId);

		}
		return this.bookRepository.getBook(bookId);
	}

}
