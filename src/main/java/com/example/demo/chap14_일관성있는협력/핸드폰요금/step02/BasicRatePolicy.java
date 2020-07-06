package com.example.demo.chap14_일관성있는협력.핸드폰요금.step02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.money.Money;

public class BasicRatePolicy implements RatePolicy {
	
	private List<FeeRule> feeRules = new ArrayList<>();
	
	public BasicRatePolicy(FeeRule... feeRules) {
		this.feeRules = Arrays.asList(feeRules);
	}

	@Override
	public Money calculateFee(Phone phone) {
		return phone.getCalls()
				.stream()
				.map(call -> calculate(call))
				.reduce(Money.ZERO, (first, second) -> first.plus(second));
	}
	
	private Money calculate(Call call) {
		return feeRules
				.stream()
				.map(rule -> rule.calculateFee(call))
				.reduce(Money.ZERO, (first, second) -> first.plus(second));
	}

}
