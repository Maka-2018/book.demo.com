package com.book.data;

import java.util.LinkedList;
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
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.book.entity.Author;
import com.book.entity.Book;
import com.book.entity.Sex;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(BookVO.class)
public class BookVOPowerMockitoTest {

	@Mock
	BookVO nBookVO;
	
	@Mock
	List<Book> listBook;
	
	@Captor
	ArgumentCaptor<Book> argumentBook = ArgumentCaptor.forClass(Book.class);
	
	@Before
	public void setUp() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		
		this.listBook = new LinkedList<Book>();
		
	}
	
	@Test
	public void test_getAllBookInformation() throws Exception{
		
		Book strBook = new Book(Integer.valueOf(25), "TDD", 
				new Author("Marine Lo", Sex.WOMAN));
		
		PowerMockito.when(nBookVO.getAllBookInformation(Matchers.any())).thenReturn(listBook);
		
		nBookVO.getAllBookInformation(strBook);
		
		Mockito.verify(nBookVO).getAllBookInformation(argumentBook.capture());
		List<Book> nBookArgumentLsit = argumentBook.getAllValues();
		
		Assert.assertEquals(strBook.getTitle(), nBookArgumentLsit.get(0).getTitle());
		Assert.assertEquals(strBook.getBookId(), nBookArgumentLsit.get(0).getBookId());
		Assert.assertEquals(strBook.getAuthor().getSex(), nBookArgumentLsit.get(0).getAuthor().getSex());

		Assert.assertEquals(strBook.getAuthor().getFullName(), nBookArgumentLsit.get(0).getAuthor().getFullName());

		
	}
	
	@After
	public void tearDown() throws Exception{
		
		this.nBookVO = null;
		Assert.assertNull(this.nBookVO);
		
		this.listBook = null;
		Assert.assertNull(this.listBook);
		
	}
}
