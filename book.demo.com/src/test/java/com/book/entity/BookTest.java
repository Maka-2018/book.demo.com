package com.book.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

public class BookTest {

	private Book book;
	private Author author;
	
	@Before
	public void setUp() throws Exception{
		
		this.author = new Author("Henry Mark", Sex.MAN);
		this.book = new Book(1, "Groovy Programming", this.author);
	}
	
	@Test
	public void test_getBookId() throws Exception{
		this.book.getBookId();
		System.out.print("Book Id: "+this.book.getBookId());
	}	
	@Test
	public void test_setBookId() throws Exception{
		this.book.setBookId(100);
	}	
	@Test
	public void test_getTitle() throws Exception{
		this.book.getTitle();
		System.out.print("Title: "+this.book.getTitle()+" \t");
	}	
	@Test
	public void test_setTilte() throws Exception{
		this.book.setTitle("Java Code");
	}	
	@Test
	public void test_getAuthorFullName() throws Exception{
		this.author.getFullName();
		System.out.print("Full Name: "+this.author.getFullName()+" \t");
	}	
	@Test
	public void test_setAuthorFullName() throws Exception{
		this.author.setFullName("Henriette Watson");
	}	
	@Test
	public void test_getAuthorSex() throws Exception{
		this.author.getSex();
		System.out.print(" Sex of author: "+this.author.getSex());
	}	
	@Test
	public void test_setAuthorSex() throws Exception{
		this.author.setSex(Sex.WOMAN);
	}
	@Test
	public void test_toString_author() throws Exception{
		this.author.toString();
		System.out.print(" Author: "+this.author.toString()+" \t");
	}
	@Test
	public void test_toString_book() throws Exception{
		this.book.toString();
		System.out.print(" Book: "+this.book.toString()+" \t");
	}
	
	@After
	public void tearDown() throws Exception{
		this.book = null;
		Assert.assertNull(this.book);
	}
}
