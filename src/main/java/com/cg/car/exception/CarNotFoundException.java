package com.cg.car.exception;

public class CarNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1631823366296521859L;

	public CarNotFoundException() {
	}

	public CarNotFoundException(String message) {
		super(message);
	}
}