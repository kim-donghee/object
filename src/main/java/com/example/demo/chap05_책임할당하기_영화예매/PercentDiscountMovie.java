package com.example.demo.chap05_책임할당하기_영화예매;

import java.time.Duration;
import java.util.List;

import com.example.demo.money.Money;

public class PercentDiscountMovie extends Movie {
	
	private double discountPercent;

	public PercentDiscountMovie(String title, Duration runningTime, Money fee,
			List<DiscountCondition> discountConditions, double discountPercent) {
		super(title, runningTime, fee, discountConditions);
		this.discountPercent = discountPercent;
	}

	@Override
	public Money calculateDiscountAmount() {
		return getFee().times(discountPercent);
	}

}
