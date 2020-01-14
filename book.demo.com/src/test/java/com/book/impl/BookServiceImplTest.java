package com.book.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
//import static org.mockito.Mockito.doThrow;

import com.book.entity.Author;
import com.book.entity.Book;
import com.book.entity.Sex;
import com.book.repository.BookRepository;


public class BookServiceImplTest {

	private BookRepository nBookRepository;
	private BookServiceImpl nBookServiceImpl;
	
	@Before
	public void setUp() throws Exception{
		
		nBookRepository = Mockito.mock(BookRepository.class);
		nBookServiceImpl = Mockito.mock(BookServiceImpl.class);
		
		nBookServiceImpl.setBookRepository(nBookRepository);
		
	}
	
	@Test
	public void test_retrieveBookDetails() throws Exception{
		
		final Integer BookID = Integer.valueOf(10);
		final String BookTitle = "Java Pro Groovy";
		final String BookAuthor = "Daniel Andersson";
		final Author newAuthor = new Author(BookAuthor, Sex.MAN);
		
		final Book newBook = new Book(BookID, BookTitle, newAuthor);
		
		Mockito.when(nBookServiceImpl.retrieveBookDetails(Matchers.anyInt())).thenReturn(newBook);
		nBookServiceImpl.retrieveBookDetails(Integer.valueOf(12));
		
		Mockito.verify(nBookServiceImpl).retrieveBookDetails(Matchers.any(Integer.class));
		
		System.out.print("Author [Book Id: "+newBook.getBookId()
			+", Tilte: "+newBook.getTitle()+", Full Name: "
				+newBook.getAuthor().getFullName()+" ]");

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_retrieveBookDetails_null() throws Exception{
		
		final Book nBookVaule = null;
		
		Mockito.when(nBookServiceImpl.retrieveBookDetails(Matchers.anyInt())).thenReturn(nBookVaule);
		nBookServiceImpl.retrieveBookDetails(new Integer(null));
		
		Mockito.verify(nBookServiceImpl).retrieveBookDetails(Matchers.any(Integer.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=IllegalArgumentException.class)
	public void test_retrieveBookDetails_greaterThanZero() throws Exception{
		
		final Book newBook = new Book(0, null, null);
		
		Mockito.when(nBookServiceImpl.retrieveBookDetails(Matchers.anyInt()))
		.thenThrow(IllegalArgumentException.class).thenReturn(newBook);
		
		nBookServiceImpl.retrieveBookDetails(new Integer(0));
		
		Mockito.verify(nBookServiceImpl).retrieveBookDetails(Matchers.anyInt());
	}
	
	@After
	public void tearDown() throws Exception
	{
		nBookServiceImpl = null;
		nBookRepository = null;
		
		Assert.assertNull(nBookServiceImpl);
		Assert.assertNull(nBookRepository);
		
	}
}
