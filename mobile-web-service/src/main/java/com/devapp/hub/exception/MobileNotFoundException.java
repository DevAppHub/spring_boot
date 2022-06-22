package com.devapp.hub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MobileNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6966783493013733331L;

	public MobileNotFoundException(String message) {
		super(message);
	}

	
}
