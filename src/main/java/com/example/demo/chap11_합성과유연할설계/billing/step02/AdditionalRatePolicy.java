package com.example.demo.chap11_합성과유연할설계.billing.step02;

import com.example.demo.money.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {
	
	private RatePolicy next;
	
	public AdditionalRatePolicy(RatePolicy next) {
		this.next = next;
	}
	
	@Override
	public Money calculateFee(Phone phone) {
		Money fee = next.calculateFee(phone);
		return afterCalculated(fee);
	}

	protected abstract Money afterCalculated(Money fee);

}
