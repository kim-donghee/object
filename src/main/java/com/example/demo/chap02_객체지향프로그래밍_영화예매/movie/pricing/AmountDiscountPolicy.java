package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.pricing;

import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.DefaultDiscountPolicy;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.DiscountCondition;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.Screening;
import com.example.demo.money.Money;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
	
	private Money discountAmount;
	

	public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}

}
