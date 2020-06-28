package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.pricing;

import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.DiscountPolicy;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.Screening;
import com.example.demo.money.Money;

public class NoneDiscountPolicy implements DiscountPolicy {

	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return Money.ZERO;
	}

}
