package com.book.run;

import org.junit.Before;
import org.junit.Test;

import com.book.entity.AuthorTest;
import com.book.entity.BookTest;
import com.book.impl.BookRepositoryImplCaptorTest;
import com.book.impl.BookRepositoryImplTest;
import com.book.impl.BookServiceImplCaptorTest;
import com.book.impl.BookServiceImplTest;
import com.demo.powermock.BookRepositoryImplPowerMockitoTest;
import com.demo.powermock.BookServiceImplPowerMockito;

public class runJunitTest {
	
	private BookTest bookTest;
	private AuthorTest authorTest;
	private BookServiceImplTest bookServImpl;
	private BookRepositoryImplTest bookRepoImpl;
	private BookRepositoryImplCaptorTest bookRepoCaptor;
	private BookServiceImplCaptorTest bookServiceCaptor;
	private BookServiceImplPowerMockito bookServiceImplPowerMockito;
	private BookRepositoryImplPowerMockitoTest bookRepositoryImplPowerMockitoTest;
	
	@Before
	public void setUp() throws Exception{
		
		this.bookTest = new BookTest();
		this.authorTest = new AuthorTest();
		
		this.bookServImpl = new BookServiceImplTest();
		this.bookRepoImpl = new BookRepositoryImplTest();		
		this.bookRepoCaptor = new BookRepositoryImplCaptorTest();
		this.bookServiceCaptor = new BookServiceImplCaptorTest();
		
		this.bookServiceImplPowerMockito = new BookServiceImplPowerMockito();
		this.bookRepositoryImplPowerMockitoTest = new BookRepositoryImplPowerMockitoTest();
	}
	
	@Test
	public void run_all_Jnuit_test() throws Exception{
		
		this.bookTest.setUp();
		this.bookTest.test_getAuthorFullName();
		this.bookTest.test_getAuthorSex();
		this.bookTest.test_getBookId();
		this.bookTest.test_getTitle();
		
		this.bookTest.test_setAuthorFullName();
		this.bookTest.test_setAuthorSex();
		this.bookTest.test_setBookId();
		this.bookTest.test_setTilte();
		this.bookTest.test_toString_author();
		this.bookTest.test_toString_book();
		this.bookTest.tearDown();
		
		this.authorTest.setUp();
		this.authorTest.hashCode_test();
		this.authorTest.equals_test();
		this.authorTest.tearDown();
		
		this.bookServImpl.setUp();
		this.bookServImpl.test_retrieveBookDetails();

		this.bookRepoImpl.setUp();
		this.bookRepoImpl.getBook();
		
		try 
		{
			this.bookServImpl.test_retrieveBookDetails_greaterThanZero();
			this.bookServImpl.test_retrieveBookDetails_null();
			this.bookRepoImpl.getBookGreaterThanZero();
			this.bookRepoImpl.getNullBook();
		} 
		catch (IllegalArgumentException e) 
		{
			System.out.print("Catch the value of IllegalArgumentException"+e);
		}
		
		this.bookRepoCaptor.setUp();
		this.bookRepoCaptor.test_retrieveBookDetails();
		
		this.bookServiceCaptor.setUp();
		this.bookServiceCaptor.test_getBook();
		this.bookServiceCaptor.test_sanity_getBook();
		
		this.bookServiceImplPowerMockito.setUp();
		this.bookServiceImplPowerMockito.test_getBook_powermockito();
		
		this.bookRepositoryImplPowerMockitoTest.setUp();
		this.bookRepositoryImplPowerMockitoTest.test_retrieveBookDetails_powermockito();
		
		
	}
}
