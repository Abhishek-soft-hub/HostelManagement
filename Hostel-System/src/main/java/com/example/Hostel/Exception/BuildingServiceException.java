package com.example.Hostel.Exception;

import org.springframework.http.HttpStatus;

public class BuildingServiceException extends RuntimeException {
	
	private HttpStatus httpStatus;
	private String getMessage;
	
	@Override
	public String getMessage() {
		
		return getMessage;
	}
	
	public HttpStatus getHtttpStatus() {
		return httpStatus;
	}

	public BuildingServiceException(HttpStatus httpStatus, String getMessage) {
	
		this.httpStatus = httpStatus;
		this.getMessage = getMessage;
	}

	

}
