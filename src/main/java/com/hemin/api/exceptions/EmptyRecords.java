package com.hemin.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Empty Records.")
public class EmptyRecords extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyRecords(String message){
		super(message);
	}
	
	public EmptyRecords(String message, Throwable cause){
		super(message,cause);
	}

}
