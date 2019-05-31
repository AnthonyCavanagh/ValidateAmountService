package com.nhs.bsa.constraintservice.service;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IncomeConstraintValidator.class)
@Documented
public @interface AmountConstraint {

	 String message() default "Amount is not divisible by a week";
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
}
