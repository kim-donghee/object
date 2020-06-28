package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.pricing;

import java.time.DayOfWeek;
import java.time.LocalTime;

import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.DiscountCondition;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.Screening;

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
				startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
				endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
	}

}
