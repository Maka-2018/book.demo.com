package com.book.entity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

	private Author FirstAuthor;
	private Author SecondAuthor;
	
	@Before
	public void setUp() throws Exception{
		
		this.FirstAuthor = new Author("Jena Pierre", Sex.MAN);
		this.SecondAuthor = new Author("Jeanne Lecoq", Sex.WOMAN);
	}
	
	@Test
	public void hashCode_test() throws Exception{
		
		Assert.assertNotEquals(FirstAuthor, SecondAuthor);
		Assert.assertNotEquals(SecondAuthor, FirstAuthor);

		int first = FirstAuthor.hashCode();
		Assert.assertNotEquals(first, SecondAuthor.hashCode());
		Assert.assertNotEquals(SecondAuthor.hashCode(), first);

	}
	
	@Test
	public void equals_test() throws Exception{
		Assert.assertNotEquals(FirstAuthor, SecondAuthor);
		Assert.assertEquals(new Author("Jeanne Lecoq", Sex.WOMAN), SecondAuthor);

		boolean FirstValue = this.FirstAuthor.equals(SecondAuthor);		
		boolean SecondValue = this.SecondAuthor.equals(FirstAuthor);
		
		Assert.assertFalse(FirstValue);
		Assert.assertFalse(SecondValue);
		
		Assert.assertEquals(FirstValue, SecondValue);

	}
	
	@After
	public void tearDown() throws Exception{
		this.FirstAuthor = null;
		Assert.assertNull(this.FirstAuthor);
		
		this.SecondAuthor = null;
		Assert.assertNull(this.SecondAuthor);
	}
}
