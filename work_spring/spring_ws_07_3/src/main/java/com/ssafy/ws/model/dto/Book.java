package com.ssafy.ws.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class Book {

	private String isbn;
	private String title;
	private String author;
	private Integer price;
	private String content;
	private String img;
	private String orgImg;
	private MultipartFile upfile;

	public Book() {
	}

	public Book(String isbn, String title, String author, Integer price, String content, String img, String orgImg,
			MultipartFile upfile) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.content = content;
		this.img = img;
		this.orgImg = orgImg;
		this.upfile = upfile;
	}
	
	public Book(String isbn, String title, String author, Integer price, String content, String img, String orgImg) {
		this(isbn, title, author, price, content, img, orgImg, null);
	}

	public MultipartFile getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=").append(isbn).append(", title=").append(title).append(", author=").append(author)
				.append(", price=").append(price).append(", content=").append(content).append(", img=").append(img)
				.append(", orgImg=").append(orgImg).append(", upfile=").append(upfile).append("]");
		return builder.toString();
	}

}
