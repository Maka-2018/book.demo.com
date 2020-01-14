package com.book.run;

import org.junit.Before;
import org.junit.Test;

import com.book.impl.BookRepositoryImplCaptorTest;
import com.book.impl.BookRepositoryImplTest;
import com.book.impl.BookServiceImplCaptorTest;
import com.book.impl.BookServiceImplTest;

public class runJunitTest {
	
	private BookServiceImplTest bookServImpl;
	private BookRepositoryImplTest bookRepoImpl;
	private BookRepositoryImplCaptorTest bookRepoCaptor;
	private BookServiceImplCaptorTest bookServiceCaptor;
	
	@Before
	public void setUp() throws Exception{
		
		this.bookServImpl = new BookServiceImplTest();
		this.bookRepoImpl = new BookRepositoryImplTest();		
		this.bookRepoCaptor = new BookRepositoryImplCaptorTest();
		this.bookServiceCaptor = new BookServiceImplCaptorTest();
	}
	
	@Test
	public void run_all_Jnuit_test() throws Exception{
		
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
		
	}
}
