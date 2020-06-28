
package com.example.demo.chap08_의존성관리하기_영화예매;

import java.time.Duration;

import com.example.demo.chap08_의존성관리하기_영화예매.pricing.AmountDiscountPolicy;
import com.example.demo.chap08_의존성관리하기_영화예매.pricing.SequenceCondition;
import com.example.demo.money.Money;

public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private DiscountPolicy discountPolicy;
	
	public Movie(String title, Duration runningTime, Money fee) {
		this(title, runningTime, fee, new AmountDiscountPolicy(Money.wons(800), new SequenceCondition(10)));
	}

	public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}

	public Money getFee() {
		return fee;
	}
	
	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}
	
}
