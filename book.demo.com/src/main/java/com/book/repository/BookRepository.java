package com.book.repository;

import com.book.entity.Book;

public interface BookRepository {

	public Book getBook(Integer bookId);
}
