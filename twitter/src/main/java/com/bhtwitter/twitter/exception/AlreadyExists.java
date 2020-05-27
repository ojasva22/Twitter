package com.bhtwitter.twitter.exception;

public class AlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyExists(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public AlreadyExists(String arg0) {
		super(arg0);
	}

	public AlreadyExists(Throwable arg0) {
		super(arg0);
		
	}
	
}
