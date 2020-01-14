package com.book.impl;

import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doThrow;

import org.junit.*;
import org.junit.Before;
import com.book.entity.Author;
import com.book.entity.Sex;
import com.book.service.BookService;
import com.book.entity.Book;

public class BookRepositoryImplTest {

	private BookService nBookServiceImpl;
	private BookRepositoryImpl nBookRepositoryImpl;
	
	@Before
	public void setUp() throws Exception
	{
		this.nBookServiceImpl = Mockito.mock(BookService.class);
		this.nBookRepositoryImpl = Mockito.mock(BookRepositoryImpl.class);
		
		this.nBookRepositoryImpl.setBookService(nBookServiceImpl);
	}
	
	@Test
	public void getBook() throws Exception
	{
		Mockito.when(this.nBookRepositoryImpl.getBook(Matchers.anyInt())).thenReturn(BookData.newBook); 
		this.nBookRepositoryImpl.getBook(BookData.BookID);
		
		Mockito.verify(this.nBookRepositoryImpl).getBook(Matchers.anyInt());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getNullBook() throws Exception
	{
		final Book returnBook = new Book(0, null, null);
		
		Mockito.when(this.nBookRepositoryImpl.getBook(Matchers.anyInt())).thenReturn(returnBook); 
		this.nBookRepositoryImpl.getBook(Integer.valueOf(new Integer(null)));
		
		Mockito.verify(this.nBookRepositoryImpl).getBook(Matchers.anyInt());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getBookGreaterThanZero() throws Exception
	{
		doThrow(IllegalArgumentException.class).when(this.nBookRepositoryImpl).getBook(Matchers.any(Integer.class)); 
		this.nBookRepositoryImpl.getBook(Integer.valueOf(2));
		
		Mockito.verify(this.nBookRepositoryImpl).getBook(Matchers.any(Integer.class));
	}
	
	@After
	public void tearDown() throws Exception
	{
		this.nBookRepositoryImpl = null;
		
		assertNull(this.nBookRepositoryImpl);
	}
	
	private static class BookData
	{
		private final static Integer BookID = Integer.valueOf(10);
		private final static String BookTitle = "Java Pro Groovy";
		private final static String BookAuthor = "Daniel Andersson";
		private static Author newAuthor = new Author(BookAuthor, Sex.MAN);
		private static Book newBook = new Book(BookID, BookTitle, newAuthor);
		
	}
	
}
