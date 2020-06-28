package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.pricing;

import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.DefaultDiscountPolicy;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.DiscountCondition;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.Screening;
import com.example.demo.money.Money;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
	
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
