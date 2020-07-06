package com.example.demo.chap14_일관성있는협력.핸드폰요금.step02;

import com.example.demo.money.Money;

public class FeeRule {
	
	private FeeCondition feeCondition;
	
	private FeePerDuration feePerDuration;

	public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
		this.feeCondition = feeCondition;
		this.feePerDuration = feePerDuration;
	}
	
	public Money calculateFee(Call call) {
		return feeCondition.findTimeIntervals(call)
				.stream()
				.map(each -> feePerDuration.calculate(each))
				.reduce(Money.ZERO, (first, second) -> first.plus(second));
	}

}
