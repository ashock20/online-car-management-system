package com.cg.car.exception;

 
 
public class TechnicianNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1631823366296521859L;

	public TechnicianNotFoundException() {
	}
	
	
	public TechnicianNotFoundException(String message) {
		super(message);
	}
}
