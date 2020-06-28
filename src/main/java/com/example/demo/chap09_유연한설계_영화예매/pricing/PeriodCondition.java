package com.example.demo.chap09_유연한설계_영화예매.pricing;

import java.time.DayOfWeek;
import java.time.LocalTime;

import com.example.demo.chap09_유연한설계_영화예매.DiscountCondition;
import com.example.demo.chap09_유연한설계_영화예매.Screening;


public class PeriodCondition implements DiscountCondition {
	
	private DayOfWeek dayOfWeek;
	
	private LocalTime startTime;
	
    private LocalTime endTime;

	public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
				screening.getStartTime().toLocalTime().compareTo(startTime) >= 0 &&
				screening.getStartTime().toLocalTime().compareTo(endTime) <= 0;
	}

}
