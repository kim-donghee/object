package com.example.demo.chap14_일관성있는협력.핸드폰요금.step01;

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
