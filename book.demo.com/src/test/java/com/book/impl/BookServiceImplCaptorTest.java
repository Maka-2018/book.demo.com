package com.book.impl;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.book.entity.Author;
import com.book.entity.Book;
import com.book.entity.Sex;
import com.book.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplCaptorTest {

	@Mock
	BookService nBookServiceImpl;
	
	@Mock
	BookRepositoryImpl nBookRepositoryImpl;
	
	@Captor
	ArgumentCaptor<Integer> argumentInteger;

	@Before
	public void setUp() throws Exception{	
		
		nBookServiceImpl = Mockito.mock(BookService.class);		
		nBookRepositoryImpl = Mockito.mock(BookRepositoryImpl.class);
		
		nBookRepositoryImpl.setBookService(nBookServiceImpl);	

	}
	
	/*
	 * Verify if object is not empty
	 */
	@Test
	public void test_sanity_getBook() throws Exception{
		
		Assert.assertNotNull(nBookServiceImpl);
		Assert.assertNotNull(nBookRepositoryImpl);

	}
	
	@Test
	public void test_getBook() throws Exception{	

		Integer BookID = Integer.valueOf(10);
		String BookTitle = "Java Pro Groovy";
		String BookAuthor = "Daniel Andersson";
		Author newAuthor = new Author(BookAuthor, Sex.MAN);
		
		Book nBookValue = new Book(BookID, BookTitle, newAuthor);		
		Mockito.when(nBookRepositoryImpl.getBook(Matchers.anyInt())).thenReturn(nBookValue);
		
		nBookRepositoryImpl.getBook(nBookValue.getBookId());
		argumentInteger = ArgumentCaptor.forClass(Integer.class);

		Mockito.verify(nBookRepositoryImpl).getBook(argumentInteger.capture());		
		List<Integer> BookIDValue = argumentInteger.getAllValues();
		
		System.out.print("[Captor Id: "+BookIDValue.get(0)+"]\n"
				+ "[Book Id: "+nBookValue.getBookId()+" ]");

		Assert.assertEquals(Integer.valueOf(10), BookIDValue.get(0));
		Assert.assertEquals(nBookValue.getBookId(), BookIDValue.get(0));

	}
	
	@After
	public void tearDown() throws Exception{

		nBookRepositoryImpl = null;
		nBookServiceImpl = null;
		Assert.assertNull(nBookServiceImpl);
		Assert.assertNull(nBookRepositoryImpl);
	}
}
