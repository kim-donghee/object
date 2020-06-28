package com.example.demo.chap05_책임할당하기_영화예매;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
		LocalDateTime whenScreened = screening.getWhenScreened();
		return dayOfWeek.equals(whenScreened.getDayOfWeek()) && 
				startTime.compareTo(whenScreened.toLocalTime()) <= 0 &&
				endTime.compareTo(whenScreened.toLocalTime()) >= 0;
	}

}
