package com.example.demo.chap08_의존성관리하기_영화예매.pricing;

import com.example.demo.chap08_의존성관리하기_영화예매.DiscountCondition;
import com.example.demo.chap08_의존성관리하기_영화예매.DiscountPolicy;
import com.example.demo.chap08_의존성관리하기_영화예매.Screening;
import com.example.demo.money.Money;

public class PercentDiscountPolicy extends DiscountPolicy {
	
	private double percent;

	public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
		super(conditions);
		this.percent = percent;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return screening.getMovieFee().times(percent);
	}

}
