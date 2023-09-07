package com.librarymanage.test.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.librarymanage.test.entities.Book;
import com.librarymanage.test.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookControl {

	@Autowired
	private BookService bookService;

//Retrieve data 
	@GetMapping()
	public List<Book> getAllBooks() {
		return bookService.findAll();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id) {
		return bookService.findById(id);
	}
	
//Add books
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.save(book);
	}
	
//Update Book
	@PutMapping("/{id}/")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		// Additional logic to ensure you're updating the correct book
		return bookService.save(book);
	}
	
//Delete Book
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteById(id);
	}	

//Check the book id and user id
	@PostMapping("/{bookId}/borrow/{userId}")
	public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable int userId) {
		Book borrowedBook = bookService.borrowBook(bookId, userId);
		if (borrowedBook != null) {
			return ResponseEntity.ok(borrowedBook);
		} else {
			// or a more descriptive error response
			return ResponseEntity.badRequest().build(); 
		}
	}

//Book return
	@PostMapping("/{bookId}/return")
	public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
		Book returnedBook = bookService.returnBook(bookId);
		if (returnedBook != null) {
			return ResponseEntity.ok(returnedBook);
		} else {
			return ResponseEntity.badRequest().build(); // or a more descriptive error response
		}
	}
}