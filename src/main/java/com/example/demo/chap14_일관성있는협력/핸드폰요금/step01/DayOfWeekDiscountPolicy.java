package com.example.demo.chap14_일관성있는협력.핸드폰요금.step01;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.time.DateTimeInterval;
import com.example.demo.money.Money;

public class DayOfWeekDiscountPolicy extends BasicRatePolicy {
	
	private List<DayOfWeekDiscountRule> rules = new ArrayList<>();
	
	public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> rules) {
		this.rules = rules;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		Money result = Money.ZERO;
		
		for(DateTimeInterval interval : call.splitByDay()) {
			for(DayOfWeekDiscountRule rule : rules) {
				result.plus(rule.calculate(interval));
			}
		}
		
		return result;
	}

}
