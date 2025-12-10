package com.example.Hostel.Exception;

import org.springframework.http.HttpStatus;

public class OrganizationServiceException extends RuntimeException {
	
	private String getMessage;
	private HttpStatus getHttpStatus;
	
	public HttpStatus getHttp() {
		return getHttpStatus;
	}

	private String getmessge() {
		return getMessage;
		
	}

	public OrganizationServiceException(String getMessage, HttpStatus getHttpStatus) {
	
		this.getMessage = getMessage;
		this.getHttpStatus = getHttpStatus;
	}
	
	
}
