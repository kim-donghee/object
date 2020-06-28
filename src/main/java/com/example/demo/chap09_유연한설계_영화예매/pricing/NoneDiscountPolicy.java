package com.example.demo.chap09_유연한설계_영화예매.pricing;

import com.example.demo.chap09_유연한설계_영화예매.DiscountCondition;
import com.example.demo.chap09_유연한설계_영화예매.DiscountPolicy;
import com.example.demo.chap09_유연한설계_영화예매.Screening;
import com.example.demo.money.Money;

public class NoneDiscountPolicy extends DiscountPolicy {

	public NoneDiscountPolicy(DiscountCondition... conditions) {
		super(conditions);
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return Money.ZERO;
	}

}
