package com.gouwuche.bean;

public class BookBean {
	private String isbn;//图书编号
	private String title;//图书标题
	private int editionNumber;
	private String copyright;
	private int publisherID;
	private String imageFile;
	private double price;
	
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
	public int getEditionNumber() {
		return editionNumber;
	}
	public void setEditionNumber(int editionNumber) {
		this.editionNumber = editionNumber;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public int getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public BookBean(String isbn, String title, int editionNumber,
			String copyright, int publisherID, String imageFile, double price) {
		this.isbn = isbn;
		this.title = title;
		this.editionNumber = editionNumber;
		this.copyright = copyright;
		this.publisherID = publisherID;
		this.imageFile = imageFile;
		this.price = price;
	}
	public BookBean() {}
	
}
