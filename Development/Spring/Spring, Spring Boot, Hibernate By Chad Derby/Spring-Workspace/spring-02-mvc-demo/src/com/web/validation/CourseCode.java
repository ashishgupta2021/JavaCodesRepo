package com.web.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/* @Target annotation tells that this annotation can be applied 
 * to either method or field.
 * 
 * @Retetntion annotation retain the annotation in java class file and
 * process it at runtime.
 * */

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	// Define default course code
	public String value() default "LUV";
	
	// Define default error message
	public String message() default "Must starts with LUV";
	
	// Define default groups
	public Class<?>[] groups() default{};
	
	// Define default payloads
	public Class<? extends Payload>[] payload() default{};

}
