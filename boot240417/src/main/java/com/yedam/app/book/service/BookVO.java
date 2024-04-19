package com.yedam.app.book.service;


import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;



import lombok.Data;


@Data
public class BookVO {
	private int bookNo;
	private String bookName;
	private String bookCoverimg;
	// 기본포맷 : yyyy/MM/dd
	// JSON   : yyyy-MM-dd //@JsonFormat(pattern="yyyy/MM/dd")..
	@DateTimeFormat(pattern="yyyy-MM-dd")
	
	private Date bookDate;
	private int bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	private int rentCount; // rent_count 별칭은..
	private int rentTotalPrice; // rent_total_price
	
	// getter setter
	public int getRentCount() {
		return rentCount;
	}
	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}
	public int getRentTotalPrice() {
		return rentTotalPrice;
	}
	public void setRentTotalPrice(int rentTotalPrice) {
		this.rentTotalPrice = rentTotalPrice;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCoverimg() {
		return bookCoverimg;
	}
	public void setBookCoverimg(String bookCoverimg) {
		this.bookCoverimg = bookCoverimg;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}
	


}
// 데이터 담는 대상.


//getter,setter.. Tostring.. 가끔은 개별적 설정이 필요,전부 @Data 안에 있다.
//@Getter
//@Setter
//@EqualsAndHashCode