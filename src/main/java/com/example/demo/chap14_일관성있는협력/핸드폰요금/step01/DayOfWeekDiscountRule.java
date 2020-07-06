package com.example.demo.chap14_일관성있는협력.핸드폰요금.step01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.time.DateTimeInterval;
import com.example.demo.money.Money;

public class DayOfWeekDiscountRule {
	
	private List<DayOfWeek> dayOfWeeks = new ArrayList<>();
	
	private Duration duration = Duration.ZERO;
	
	private Money amount = Money.ZERO;

	public DayOfWeekDiscountRule(List<DayOfWeek> dayOfWeeks, Duration duration, Money amount) {
		this.dayOfWeeks = dayOfWeeks;
		this.duration = duration;
		this.amount = amount;
	}
	
	public Money calculate(DateTimeInterval interval) {
		if(dayOfWeeks.contains(interval.getFrom().getDayOfWeek())) {
			return amount.times(interval.duration().getSeconds() / duration.getSeconds());
		}
		
		return Money.ZERO;
	}

}
