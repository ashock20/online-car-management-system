package com.cg.car.exception;

public class EvaluationReportNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1631823366296521859L;

	public EvaluationReportNotFoundException() {
	}
	
	public EvaluationReportNotFoundException(String message) {
		super(message);
	}
}
