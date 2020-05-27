package com.bhtwitter.twitter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TweetNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TweetNotFoundException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public TweetNotFoundException(String message) {
		super(message);
	
	}

	public TweetNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	
	
}
