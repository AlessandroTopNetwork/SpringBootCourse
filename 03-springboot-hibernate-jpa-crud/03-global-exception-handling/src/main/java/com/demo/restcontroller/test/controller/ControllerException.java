package com.demo.restcontroller.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.restcontroller.test.customexception.StudentCustomException;
import com.demo.restcontroller.test.entity.StudentError;

@ControllerAdvice
public class ControllerException {
	
//	 @ExceptionHandler(Exception.class)
//	 public ResponseEntity<String> handleException(Exception ex) {
//		 // Log the exception or perform other actions
//		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//				 .body("Errore interno del server, errore : " + ex.getMessage());
//	 }

		//exception cathc gerneric , cathc genric excetion and response genric error
//		@ExceptionHandler(Exception.class)
//		public ResponseEntity<String> handleException(Exception ex) {
//			// Log the exception or perform other actions
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("Errore interno del server, errore : " + ex.getMessage());
//		}
		
		//from cousre
		// cacth specific exception studen
		@ExceptionHandler//(StudentCustomException.class)
		public ResponseEntity<StudentError> studentNotFoundException(StudentCustomException ex) {
			// Log the exception or perform other actions
			
			StudentError errorStudent = new StudentError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
			
			return new ResponseEntity<>(errorStudent, HttpStatus.NOT_FOUND);
		}
		
		//from cousre
		// cacth specific exception student 
		@ExceptionHandler//(StudentCustomException.class)
		public ResponseEntity<StudentError> studentNotFoundException(Exception ex) {
			// Log the exception or perform other actions
			
			StudentError errorStudent = new StudentError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
			
			return new ResponseEntity<>(errorStudent, HttpStatus.BAD_REQUEST);
		}

}
