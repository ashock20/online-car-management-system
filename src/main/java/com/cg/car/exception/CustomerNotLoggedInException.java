package com.cg.car.exception;

public class CustomerNotLoggedInException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1631823366296521859L;

	public CustomerNotLoggedInException() {
	}

	public CustomerNotLoggedInException(String message) {
		super(message);
	}
}