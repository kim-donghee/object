package com.example.demo.chap14_일관성있는협력.핸드폰요금.step02;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.time.DateTimeInterval;

public class DurationFeeCondition implements FeeCondition {
	
	private Duration from;
	
	private Duration to;

	public DurationFeeCondition(Duration from, Duration to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public List<DateTimeInterval> findTimeIntervals(Call call) {
		if(call.getDateTimeInterval().duration().compareTo(from) < 0) {
			return Collections.emptyList();
		}
		
		return Arrays.asList(DateTimeInterval.of(
				call.getDateTimeInterval().getFrom().plus(from),
				call.getDateTimeInterval().duration().compareTo(to) > 0 ? 
						call.getDateTimeInterval().getFrom().plus(to) : 
						call.getDateTimeInterval().getTo()));
	}
	
}


