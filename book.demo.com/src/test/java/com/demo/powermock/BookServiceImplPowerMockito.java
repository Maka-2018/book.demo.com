package com.demo.powermock;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
import org.mockito.runners.MockitoJUnitRunner;
import com.book.entity.Author;
import com.book.entity.Book;
import com.book.entity.Sex;
import com.book.impl.BookRepositoryImpl;
import com.book.impl.BookServiceImpl;
import com.book.service.BookService;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(BookServiceImpl.class)
public class BookServiceImplPowerMockito {
	
	@InjectMocks
	BookService nBookServiceImpl = new BookServiceImpl();

	@Mock 
	BookRepositoryImpl nBookRepositoryImpl;
	
	private Book strBook;
	
	@Before
	public void setUp() throws Exception{
		
		strBook = new Book(100, "Groovy", new Author("Jean Robert", Sex.MAN));

		nBookRepositoryImpl = PowerMockito.mock(BookRepositoryImpl.class);
		
		nBookRepositoryImpl.setBookService(nBookServiceImpl);
	}
	
	@Test
	public void test_getBook_powermockito() throws Exception{
		
		
		PowerMockito.when(nBookRepositoryImpl.getBook(Matchers.anyInt())).thenReturn(strBook);
		
		Book actualBook = nBookRepositoryImpl.getBook(Matchers.anyInt());
		
		Assert.assertEquals(Sex.MAN, actualBook.getAuthor().getSex());		
		Assert.assertEquals(Integer.valueOf(100), actualBook.getBookId());
		Assert.assertEquals("Jean Robert", actualBook.getAuthor().getFullName());
		
		Mockito.verify(nBookRepositoryImpl).getBook(Matchers.anyInt());
				
	}
	
	@After
	public void tearDown() throws Exception{
		nBookRepositoryImpl = null;
		Assert.assertNull(nBookRepositoryImpl);
	}
	
}

