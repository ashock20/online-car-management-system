package com.cg.car.exception;

public class TransactionNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionNotFoundException()
	{
	}
		public TransactionNotFoundException(String message) {
			super(message);
		}
	}


