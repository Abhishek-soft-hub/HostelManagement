package com.example.Hostel.Exception;

import org.springframework.http.HttpStatus;

public class PayementServiceException extends RuntimeException {

	private String getMessag;

	private HttpStatus gethttpHttpStatus;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	public HttpStatus getHttpStatus() {
		return gethttpHttpStatus;

	}

	public PayementServiceException(String getMessag, HttpStatus gethttpHttpStatus) {
		super();
		this.getMessag = getMessag;
		this.gethttpHttpStatus = gethttpHttpStatus;
	}

}
