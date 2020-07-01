package com.example.demo.chap11_합성과유연할설계.billing.step02;

import com.example.demo.money.Money;

public class TaxablePolicy extends AdditionalRatePolicy {
	
	private double taxRatio;
	
	public TaxablePolicy(RatePolicy next, double taxRatio) {
		super(next);
		this.taxRatio = taxRatio;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return fee.plus(fee.times(taxRatio));
	}

}
