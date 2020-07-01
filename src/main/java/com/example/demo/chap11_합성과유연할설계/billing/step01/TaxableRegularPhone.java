package com.example.demo.chap11_합성과유연할설계.billing.step01;

import java.time.Duration;

import com.example.demo.money.Money;

public class TaxableRegularPhone extends RegularPhone {
	private double taxRate;

	public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
		super(amount, seconds);
		this.taxRate = taxRate;
	}
	
	@Override
	protected Money afterCalculated(Money fee) {
		return fee.plus(fee.times(taxRate));
	}
	
}
