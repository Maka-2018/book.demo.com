package com.book.run;

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
import org.powermock.modules.junit4.PowerMockRunner;

import com.book.entity.Book;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(BookPattern.class)
public class BookPatternJunitTest {
	
	@Mock
	BookPattern nBookPattern;
	
	@Captor
	ArgumentCaptor<Book> bookArgument = ArgumentCaptor.forClass(Book.class);
	
	@Before
	public void setUp() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		nBookPattern = PowerMockito.mock(BookPattern.class);


	}
	
	@Test
	public void test_main() throws Exception{
		 final String[] strValue = {"",""};
		 BookPattern.main(strValue);		 
		 
	}
	
	
}
