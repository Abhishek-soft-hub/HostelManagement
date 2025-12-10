package com.example.Hostel.Exception;

import org.springframework.http.HttpStatus;

public class RoomServiceException extends RuntimeException {

	
	private HttpStatus httpStatus;
	private String getMessage;
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return getMessage;
	}
	
	public HttpStatus getHtttpStatus() {
		return httpStatus;
	}

	public RoomServiceException(HttpStatus httpStatus, String getMessage) {
	
		this.httpStatus = httpStatus;
		this.getMessage = getMessage;
	}
}
