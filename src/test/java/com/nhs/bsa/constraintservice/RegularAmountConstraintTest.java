package com.nhs.bsa.constraintservice;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.nhs.bsa.constraintservice.model.RegularAmount;
import com.nhs.bsa.constraintservice.model.RegularAmount.Frequency;

public class RegularAmountConstraintTest {
	
	private static final String ERROR_MESSAGE = "Amount is not divisible by a week";

	private Validator validator;

    @Before
    public void setUp() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
    
    @Test
    public void testWeekPass(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("66");
    	amount.setFrequency(Frequency.WEEK);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testTwoWeeksPass1(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("100");
    	amount.setFrequency(Frequency.TWO_WEEK);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testTwoWeeksPass2(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("100.50");
    	amount.setFrequency(Frequency.TWO_WEEK);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testTwoWeeksFail(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("100.51");
    	amount.setFrequency(Frequency.TWO_WEEK);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(1, violations.size());
    	Iterator<ConstraintViolation<RegularAmount>> iter = violations.iterator();
    	while(iter.hasNext()){
    		ConstraintViolation<RegularAmount> cons = iter.next();
    		assertEquals(ERROR_MESSAGE,cons.getMessage());
    	}
    }
    
    @Test
    public void testFourWeeksPass1(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("100");
    	amount.setFrequency(Frequency.FOUR_WEEK);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testFourWeeksPass2(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("100.40");
    	amount.setFrequency(Frequency.FOUR_WEEK);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(0, violations.size());
    }
   
    @Test
    public void testFourWeeksFail(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("100.41");
    	amount.setFrequency(Frequency.FOUR_WEEK);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(1, violations.size());
    	Iterator<ConstraintViolation<RegularAmount>> iter = violations.iterator();
    	while(iter.hasNext()){
    		ConstraintViolation<RegularAmount> cons = iter.next();
    		assertEquals(ERROR_MESSAGE,cons.getMessage());
    	}
    }
    
    @Test
    public void testMonthPass(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("450");
    	amount.setFrequency(Frequency.MONTH);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testMonthFail(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("450.50");
    	amount.setFrequency(Frequency.MONTH);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(1, violations.size());
    	Iterator<ConstraintViolation<RegularAmount>> iter = violations.iterator();
    	while(iter.hasNext()){
    		ConstraintViolation<RegularAmount> cons = iter.next();
    		assertEquals(ERROR_MESSAGE,cons.getMessage());
    	}
    }
    
    @Test
    public void testQuarterPass(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("1300");
    	amount.setFrequency(Frequency.QUARTER);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testQuarterFail(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("1300.60");
    	amount.setFrequency(Frequency.QUARTER);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(1, violations.size());
    	Iterator<ConstraintViolation<RegularAmount>> iter = violations.iterator();
    	while(iter.hasNext()){
    		ConstraintViolation<RegularAmount> cons = iter.next();
    		assertEquals(ERROR_MESSAGE,cons.getMessage());
    	}
    }
    
    @Test
    public void testYearPass1(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("520");
    	amount.setFrequency(Frequency.YEAR);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testYearPass2(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("520.52");
    	amount.setFrequency(Frequency.YEAR);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(0, violations.size());
    }
    
    
    @Test
    public void testYearFail(){
    	RegularAmount amount = new RegularAmount();
    	amount.setAmount("520.53");
    	amount.setFrequency(Frequency.YEAR);
    	Set<ConstraintViolation<RegularAmount>> violations = validator.validate(amount);
    	assertEquals(1, violations.size());
    	Iterator<ConstraintViolation<RegularAmount>> iter = violations.iterator();
    	while(iter.hasNext()){
    		ConstraintViolation<RegularAmount> cons = iter.next();
    		assertEquals(ERROR_MESSAGE,cons.getMessage());
    	}
    }
}
