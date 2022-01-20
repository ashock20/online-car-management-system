package com.cg.car.exception;

public class AdminNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1631823366296521859L;

	public AdminNotFoundException() {
	}

	public AdminNotFoundException(String message) {
		super(message);
	}
}