package com.nhs.bsa.constraintservice.model;

import com.nhs.bsa.constraintservice.service.AmountConstraint;

@AmountConstraint
public class RegularAmount {

	private Frequency frequency;
	private String amount;
	
	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public enum Frequency {
		WEEK, TWO_WEEK, FOUR_WEEK, MONTH, QUARTER, YEAR;
	}

	@Override
	public String toString() {
		return "RegularAmount [frequency=" + frequency + ", amount=" + amount + "]";
	}
}
