package com.book.entity;

public class Book {

	private Integer Id;
	private String Title;
	private Author AuthorName;
	
	public Book(int intValue, String strTitle, Author strAuthor)
	{
		this.Id = intValue;
		this.Title = strTitle;
		this.AuthorName = strAuthor;
	}	
	public Integer getBookId() {
		return Id;
	}
	public void setBookId(Integer id) {
		this.Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public Author getAuthor() {
		return AuthorName;
	}
	public void setAuthor(Author author) {
		this.AuthorName = author;
	}
	
	@Override
	public String toString() {
		return "BookId: " +Id+ ", Title: " +Title+ ", Author: " +AuthorName;
	}

}
