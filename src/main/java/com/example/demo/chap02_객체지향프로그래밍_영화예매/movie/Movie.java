package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie;

import java.time.Duration;

import com.example.demo.money.Money;

public class Movie {
	
	private String title;
	
	private Duration runningTime;
	
	private Money fee;
	
	private DiscountPolicy discountPolicy;

	public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}
	
	public Money getFee() {
		return this.fee;
	}
	
	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}

}
