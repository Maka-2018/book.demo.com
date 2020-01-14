package com.demo.powermock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.mockito.runners.MockitoJUnitRunner;
import com.book.entity.Author;
import com.book.entity.Book;
import com.book.entity.Sex;
import com.book.impl.BookRepositoryImpl;
import com.book.impl.BookServiceImpl;
import com.book.repository.BookRepository;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(BookServiceImpl.class)
public class BookRepositoryImplPowerMockitoTest {

	@InjectMocks
	BookRepository nBookRepositoryImpl = new BookRepositoryImpl();
	
	@Mock
	BookServiceImpl nBookServiceImpl;

	@Before
	public void setUp() throws Exception{
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_retrieveBookDetails_powermockito() throws Exception{
		
		Book strBook = new Book(100, "Java MVC", new Author("Jena Robert", Sex.MAN));
		
		PowerMockito.when(nBookServiceImpl.retrieveBookDetails(Matchers.anyInt())).thenReturn(strBook);
		
		Book actualBook = nBookServiceImpl.retrieveBookDetails(Matchers.anyInt());
		
		Assert.assertEquals("Java MVC", actualBook.getTitle());
		Assert.assertEquals(Sex.MAN, actualBook.getAuthor().getSex());
		
		Assert.assertEquals(Integer.valueOf(100), actualBook.getBookId());


		Mockito.verify(nBookServiceImpl).retrieveBookDetails(Matchers.anyInt());
						
	}

}
