package com.chanpreet.practice.customAnnotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
implements  ConstraintValidator<CourseCode, String>{

	String codePrefix;
	@Override
	public void initialize(CourseCode theCourseCode) {
		codePrefix=theCourseCode.value();
		
	}

	@Override
	public boolean isValid(String theCode, 
			ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result;
		if(theCode!=null)
		{
			result=theCode.startsWith(codePrefix);
		}
		else 
		{
			result=true;
		}
		return result;
	}
	

}
