package com.example.demo.chap05_책임할당하기_영화예매;

import java.time.Duration;
import java.util.List;

import com.example.demo.money.Money;

public abstract class Movie {

	private String title;
	private Duration runningTime;
	private Money fee;
	
	private List<DiscountCondition> discountConditions;

	
	public Movie(String title, Duration runningTime, Money fee, 
			List<DiscountCondition> discountConditions) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountConditions = discountConditions;
	}

	public Money calculateMovieFee(Screening screening) {
		if(isDiscountable(screening)) {
			return fee.minus(calculateDiscountAmount());
		}
		
		return fee;
	}
	
	abstract public Money calculateDiscountAmount();
	
	protected Money getFee() {
        return fee;
    }

	private boolean isDiscountable(Screening screening) {
		return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening)); 
	}

}
