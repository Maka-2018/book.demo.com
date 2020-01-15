package com.book.run;

import java.util.List;

import com.book.data.BookVO;
import com.book.entity.Book;

public class BookPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BookVO bookVO = new BookVO();
		
		List<Book> allBook = bookVO.getAllBookInformation();
		
		for (Book book : allBook) 
		{
			System.out.print("\t"+book.getBookId()+"\t"+book.getTitle()+
					"\t"+book.getAuthor().getFullName()+"\t"+book.getAuthor().getSex()
					+"\n");
		}
	}

}
