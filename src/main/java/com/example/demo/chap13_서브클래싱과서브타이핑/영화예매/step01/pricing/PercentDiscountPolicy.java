package com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.pricing;

import com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.DiscountCondition;
import com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.DiscountPolicy;
import com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.Screening;
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
