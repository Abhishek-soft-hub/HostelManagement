package com.example.Hostel.dtos;

public class PaymentDto {

	private double amount;
	private String status;
	private String paymentMehtod;
	private int bookId;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMehtod() {
		return paymentMehtod;
	}

	public void setPaymentMehtod(String paymentMehtod) {
		this.paymentMehtod = paymentMehtod;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}
