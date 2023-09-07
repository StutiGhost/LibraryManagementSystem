package com.librarymanage.test.services;

import com.librarymanage.test.entities.Book;
import com.librarymanage.test.entities.User;
import com.librarymanage.test.repositiory.BookRepository;
import com.librarymanage.test.repositiory.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Book> findAll() //Find all Books
	{
		return bookRepository.findAll();
	}

	public Book findById(Long id) 	//Find books by bookId
	{
		return bookRepository.findById(id).orElse(null);
	}

	public Book save(Book book)		//Add Books
	{
		return bookRepository.save(book);
	}

	public void deleteById(Long id) 	//Delete books by bookId
	{
		bookRepository.deleteById(id);
	}

	public Book borrowBook(Long bookId, int userId) 	//Borrow books 
	{
		Book book = findById(bookId);
		User user = userRepository.findById(userId).orElse(null);

		if (book != null && !book.isBorrowed() && user != null) {
			book.setBorrowedBy(user);
			book.setBorrowed(true);
			return save(book);
		} else
			{
			//System.out.println("Book not found, book not borrowed");
			return null;
			}
	}

	public Book returnBook(Long bookId)  //Check whether the book is borrowed or not
	{
		Book book = findById(bookId);
		if (book != null && book.isBorrowed()) {
			book.setBorrowedBy(null);
			book.setBorrowed(false);
			return save(book);
		} else
		{
			System.out.println("Book not found, book not borrowed");
			return null;
		}
			
	}
}
