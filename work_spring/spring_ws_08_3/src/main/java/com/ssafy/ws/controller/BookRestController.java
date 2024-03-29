package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bookapi")
@CrossOrigin("*")
public class BookRestController {

	@Autowired
	private BookService bookService;

	
	// isbn 번호로 도서 조회
	@GetMapping("/book/{isbn}")
	@ApiOperation(value = "{isbn}에 해당하는 도서 정보를 반환한다.", response = Book.class)
	public ResponseEntity<?> select(@PathVariable String isbn) {

		try {
			Book book = bookService.select(isbn);
			if (book != null) {
				return new ResponseEntity<Book>(book, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 검색 조건에 맞는 도서 목록 반환
	@GetMapping("/book")
	@ApiOperation(value = "query string에 해당하는 검색 조건에 해당하는 도서 목록을 반환한다.", response = Book.class)
	public ResponseEntity<?> search(@ModelAttribute SearchCondition condition) {

		try {
			List<Book> books = bookService.search(condition);
			if (books != null && books.size() > 0) {
				return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/book")
	@ApiOperation(value = "Book 객체를 저장한다.", response = Integer.class)
	public ResponseEntity<?> insert(Book book, @RequestPart(required = false) MultipartFile file) {
		try {
			int result = bookService.insert(book);
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);

		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/book")
	@ApiOperation(value = "Book 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<?> update(Book book, @RequestPart(required = false) MultipartFile file) {
		try {
			int result = bookService.update(book);
			if (result == 0) {
				return new ResponseEntity<Integer>(result, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
			}

		} 
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/book/{isbn}")
	@ApiOperation(value = "Book 객체를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable String isbn) {
		try {
			int result = bookService.delete(isbn);
			if (result == 0) {
				return new ResponseEntity<Integer>(result, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
			}

		}
		catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
