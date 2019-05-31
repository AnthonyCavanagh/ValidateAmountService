package com.nhs.bsa.constraintservice.service;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nhs.bsa.constraintservice.model.RegularAmount;

public class IncomeConstraintValidator implements ConstraintValidator<AmountConstraint, RegularAmount> {

	private static final int ZERO = 0;
	private static final int TWO_WEEKS = 2;
	private static final int FOUR_WEEKS = 4;
	private static final double MONTH = 4.5;
	private static final int QUARTER = 13;
	private static final int YEAR = 52;

	@Override
	public void initialize(AmountConstraint arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(RegularAmount amount, ConstraintValidatorContext arg1) {
		if(amount.getFrequency().equals(RegularAmount.Frequency.WEEK)){
			return true;
		} else if(amount.getFrequency().equals(RegularAmount.Frequency.TWO_WEEK)){
			return convert(amount.getAmount(), TWO_WEEKS);
		} else if(amount.getFrequency().equals(RegularAmount.Frequency.FOUR_WEEK)){
			return convert(amount.getAmount(), FOUR_WEEKS);
		} else if(amount.getFrequency().equals(RegularAmount.Frequency.MONTH)){
			return convert(amount.getAmount(), MONTH);
		}
		else if(amount.getFrequency().equals(RegularAmount.Frequency.QUARTER)){
			return convert(amount.getAmount(), QUARTER);
		}
		else if(amount.getFrequency().equals(RegularAmount.Frequency.YEAR)){
			return convert(amount.getAmount(), YEAR);
		}
		return false;
	}

	private boolean convert(String amount, int devisor) {
		BigDecimal db = new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
		if (amount.contains(".")) {
			db = db.movePointRight(2);
		}
		int amt = db.intValue() % devisor;
		if (ZERO == amt) {
			return true;
		}
		return false;
	}
	
	private boolean convert(String amount, double devisor) {
		BigDecimal db = new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
		if (amount.contains(".")) {
			db = db.movePointRight(2);
		}
		double amt = db.intValue() % devisor;
		if (ZERO == amt) {
			return true;
		}
		return false;
	}
}
