package com.example.Hostel.dtos;

import java.time.LocalDate;

public class BookingDto {

	private LocalDate bookingDate;
	private LocalDate chekIn;
	private LocalDate checkOut;

	private String paymetMethod;
	private int bedId;
	private int userId;

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getChekIn() {
		return chekIn;
	}

	public void setChekIn(LocalDate chekIn) {
		this.chekIn = chekIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public String getPaymetMethod() {
		return paymetMethod;
	}

	public void setPaymetMethod(String paymetMethod) {
		this.paymetMethod = paymetMethod;
	}

	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}