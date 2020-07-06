package com.example.demo.chap14_일관성있는협력.핸드폰요금.step02;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.time.DateTimeInterval;

public class DayOfWeekFeeCondition implements FeeCondition {
	
	private List<DayOfWeek> dayOfWeeks = new ArrayList<>();
	
	public DayOfWeekFeeCondition(DayOfWeek... dayOfWeeks) {
		this.dayOfWeeks = Arrays.asList(dayOfWeeks);
	}

	@Override
	public List<DateTimeInterval> findTimeIntervals(Call call) {
		return call.getDateTimeInterval().splitByDay()
				.stream()
				.filter(each -> dayOfWeeks.contains(each.getFrom().getDayOfWeek()))
				.collect(Collectors.toList());
	}

}
