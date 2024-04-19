package com.springbootdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstrainValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD}) // taget of annotation
@Retention(RetentionPolicy.RUNTIME) // diacimo di voleva usare anche drante esecuzione della jvm
public @interface CourseCode {
	
	// define default corse code
	public String value() default "TEST";
	
	// define default error message
	public String message() default "must start with TEST";
	
	// this two object is required for annotation
	
	// define defult gruop 
	public Class<?>[] groups() default {}; // default list off generic class empty
	
	// define default payload
	public Class<? extends Payload>[] payload() default {};  // genric list of class extends payload

}
