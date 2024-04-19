package com.springbootdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//@Getter
//@Setter
public class CourseCodeConstrainValidation implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
		
	@Override
	public void initialize(CourseCode theCourseCode) { // init get value of "value" field into annotation @CourseCode(value ="this value")
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) { // get value of field annotation with your annotation and check it is valid a
		
		if(null != value) {
			return value.startsWith(coursePrefix);
		} else {
			return false;
		}
		
	}

}
