package com.example.demo.chap11_합성과유연할설계.billing.step02;

import com.example.demo.money.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {
	
	private Money discountAmount;
	
	public RateDiscountablePolicy(RatePolicy next, Money discountAmount) {
		super(next);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return fee.minus(discountAmount);
	}

}
