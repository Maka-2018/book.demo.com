package com.book.run;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;


@PrepareForTest(BookPattern.class)
public class BookPatternJunitTest {
	
	@Mock
	BookPattern nBookPattern;
	
	@Before
	public void setUp() throws Exception{
		
		 MockitoAnnotations.initMocks(this);

		 this.nBookPattern = PowerMockito.mock(BookPattern.class);
	}
	
	@SuppressWarnings({"static-access" })
	@Test
	public void test_main() throws Exception{
		 
		String[] strValue = {"VALUE"};
				
		this.nBookPattern.main(strValue);
		
		Assert.assertNotNull(this.nBookPattern);	
		 
	}
	
	
}
