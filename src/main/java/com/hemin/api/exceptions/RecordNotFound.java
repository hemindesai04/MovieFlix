package com.hemin.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Record Not Found.")
public class RecordNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFound(String message){
		super(message);
	}
	
	public RecordNotFound(String message, Throwable cause){
		super(message,cause);
	}
	
}
