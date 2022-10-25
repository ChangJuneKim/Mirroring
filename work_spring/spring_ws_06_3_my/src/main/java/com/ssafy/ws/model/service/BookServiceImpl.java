package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.BookMapper;
import com.ssafy.ws.model.dto.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookMapper bookMapper;

	public BookServiceImpl() {
	}

	public BookMapper getBookRepo() {
		return bookMapper;
	}

	@Autowired
	public void setBookRepo(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	@Override
	public int insert(Book book) {
		// TODO Auto-generated method stub
		int count = bookMapper.insert(book);
		return count;
	}

	@Override
	public int update(Book book) {
		// TODO Auto-generated method stub
		int count = bookMapper.update(book);
		return count;
	}

	@Override
	public int delete(String isbn) {
		// TODO Auto-generated method stub
		int count = bookMapper.delete(isbn);
		return count;
	}

	@Override
	public Book select(String isbn) {
		return bookMapper.select(isbn);
	}

	@Override
	public List<Book> search() {
		// TODO Auto-generated method stub
		return bookMapper.search();
	}

}
