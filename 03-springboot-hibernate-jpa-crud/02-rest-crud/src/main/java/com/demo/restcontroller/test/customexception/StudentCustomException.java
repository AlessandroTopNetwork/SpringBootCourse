package com.demo.restcontroller.test.customexception;

public class StudentCustomException extends RuntimeException{

	public StudentCustomException(String message) {
		super(message);
	}

	public StudentCustomException(Throwable cause) {
		super(cause);
	}

	public StudentCustomException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
