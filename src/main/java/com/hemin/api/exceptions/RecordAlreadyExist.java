package com.hemin.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Record Already Exist.")
public class RecordAlreadyExist extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public RecordAlreadyExist(String message){
		super(message);
	}
	
	public RecordAlreadyExist(String message, Throwable cause){
		super(message, cause);
	}

}
