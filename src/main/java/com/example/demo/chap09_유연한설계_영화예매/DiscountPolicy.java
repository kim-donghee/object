package com.example.demo.chap09_유연한설계_영화예매;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.money.Money;

public abstract class DiscountPolicy {
	
	private List<DiscountCondition> conditions = new ArrayList<>();
	
	public DiscountPolicy(DiscountCondition...conditions) {
		this.conditions = Arrays.asList(conditions);
	}
	
	public Money calculateDiscountAmount(Screening screening) {
		for(DiscountCondition condition : conditions) {
			if(condition.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}
		return Money.ZERO;
	}
	
	abstract protected Money getDiscountAmount(Screening screening);

}
