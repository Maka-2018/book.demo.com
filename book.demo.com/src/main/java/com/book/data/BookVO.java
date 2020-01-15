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
	
	public List<Book> getAllBookInformation(Book strBook){
				
		List<Book> listBook = new LinkedList<Book>();

		strBook.setBookId(Integer.valueOf(35));
		strBook.setTitle("UX Design");
		strBook.setAuthor(new Author("Marine Lo", Sex.WOMAN));
		listBook.add(strBook);

		for (Book book : listBook) {
			
			this.bookList.add(book);
		}
		
		return this.bookList;
		
	}
}
