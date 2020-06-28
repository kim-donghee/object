package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie;

import java.util.Arrays;
import java.util.List;

import com.example.demo.money.Money;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
	
	private List<DiscountCondition> conditions;
	
	public DefaultDiscountPolicy(DiscountCondition ... conditions) {
		this.conditions = Arrays.asList(conditions);
	}

	public Money calculateDiscountAmount(Screening screening) {
		for(DiscountCondition condition : conditions) {
			if(condition.isSatisfiedBy(screening))
				return getDiscountAmount(screening);
		}
		return Money.ZERO;
	}
	
	abstract protected Money getDiscountAmount(Screening screening);

}
