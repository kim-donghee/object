package com.example.demo.chap05_책임할당하기_영화예매;

import java.time.Duration;
import java.util.List;

import com.example.demo.money.Money;

public class NoneDiscountMovie extends Movie {
	
	public NoneDiscountMovie(String title, Duration runningTime, Money fee,
			List<DiscountCondition> discountConditions) {
		super(title, runningTime, fee, discountConditions);
	}

	@Override
	public Money calculateDiscountAmount() {
		return Money.ZERO;
	}

}
