package com.example.Hostel.Exception;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;

public class BookingServiceException extends RuntimeException {

	private String getMessage;
	private HttpStatus httpStatus;

	@Override
	public String getMessage() {

		return getMessage;
	}

	public HttpStatus getHtttpStatus() {
		return httpStatus;
	}

	public BookingServiceException(String getMessage, HttpStatus httpStatus) {

		this.getMessage = getMessage;
		this.httpStatus = httpStatus;
	}
}
