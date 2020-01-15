package com.book.data;

import java.util.*;

import org.mockito.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.book.entity.Author;
import com.book.entity.Book;
import com.book.entity.Sex;


public class BookVOMockitoTest {

	@Mock
	BookVO nBookVO;
	
	@Mock
	List<Book> listBook;
	
	@Before
	public void setUp() throws Exception{
		
		this.nBookVO = Mockito.mock(BookVO.class);
		this.listBook = new LinkedList<Book>();
		
	}
	
	@Test
	public void test_getBookList() throws Exception{
		
		Mockito.when(nBookVO.getBookList()).thenReturn(listBook);
		
		this.nBookVO.getBookList();
		
		Mockito.verify(nBookVO).getBookList();
	}
	
	@Test
	public void test_setBookList() throws Exception{
				
		this.nBookVO.setBookList(listBook);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_getAllBookInformation() throws Exception{
		
		Book strBook = new Book(Integer.valueOf(25), "TDD", 
				new Author("Marine Lo", Sex.WOMAN));
		
		Mockito.when(nBookVO.getAllBookInformation(strBook)).thenReturn(Matchers.anyList());
		
		List<Book> resultBook = nBookVO.getAllBookInformation(strBook);
		
		Mockito.verify(nBookVO).getAllBookInformation(strBook);
		
		Assert.assertNotNull(resultBook);

		
	}
	
	@After
	public void tearDown() throws Exception{
		
		this.nBookVO = null;
		Assert.assertNull(this.nBookVO);
		
		this.listBook = null;
		Assert.assertNull(this.listBook);
		
	}
	
}
