package com.example.demo.chap14_일관성있는협력.핸드폰요금.step01;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.money.Money;

public class DurationDiscountPolicy extends BasicRatePolicy {

	private List<DurationDiscountRule> rules = new ArrayList<>();

	public DurationDiscountPolicy(List<DurationDiscountRule> rules) {
		this.rules = rules;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		Money result = Money.ZERO;
		for (DurationDiscountRule rule : rules) {
			result = result.plus(rule.calculate(call));
		}
		return result;
	}

}
