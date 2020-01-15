package com.book.data;

import java.util.LinkedList;
import java.util.List;

import com.book.entity.Author;
import com.book.entity.Book;
import com.book.entity.Sex;

public class BookVO {

	private List<Book> bookList;
	
	public BookVO(){
				
		this.bookList = new LinkedList<Book>();
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	public LinkedList<Book> getAllBookInformation(){
		
		List<Book> listBook = new LinkedList<Book>();
		
		listBook.add(new Book(15, "Java Code", new Author("Minos Soumahoro", Sex.MAN)));
		listBook.add(new Book(20, "Xcode View", new Author("Jennifer Manos", Sex.WOMAN)));
		listBook.add(new Book(25, "C++ Code", new Author("Thomas Mark", Sex.MAN)));
		listBook.add(new Book(35, "UX Design", new Author("Marine Lo", Sex.WOMAN)));

		for (Book book : listBook) {
			
			this.bookList.add(book);
		}
		
		return (LinkedList<Book>) this.bookList;
		
	}
}
