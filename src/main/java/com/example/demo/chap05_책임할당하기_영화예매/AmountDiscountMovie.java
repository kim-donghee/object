package com.example.demo.chap05_책임할당하기_영화예매;

import java.time.Duration;
import java.util.List;

import com.example.demo.money.Money;

public class AmountDiscountMovie extends Movie {
	
	private Money discountAmount;

	public AmountDiscountMovie(String title, Duration runningTime, Money fee,
			List<DiscountCondition> discountConditions, Money discountAmount) {
		super(title, runningTime, fee, discountConditions);
		this.discountAmount = discountAmount;
	}
	
	@Override
	public Money calculateDiscountAmount() {
		return discountAmount;
	}

}
