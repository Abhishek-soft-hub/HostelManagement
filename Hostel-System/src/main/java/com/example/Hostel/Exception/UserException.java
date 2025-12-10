package com.example.Hostel.Exception;


import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {
	
	private String message;
	private HttpStatus httpstatus;
	
	@Override
	public String getMessage() {
		
		return message;
	}
	
	public HttpStatus getHttp(){
		return httpstatus;
	}

	public UserException(String message, HttpStatus httpstatus) {
		this.message = message;
		this.httpstatus = httpstatus;
	}
	
	

}
