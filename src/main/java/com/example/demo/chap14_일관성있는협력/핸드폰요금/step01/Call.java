package com.example.demo.chap14_일관성있는협력.핸드폰요금.step01;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.time.DateTimeInterval;

public class Call {
	
	private DateTimeInterval interval;

	public Call(LocalDateTime from, LocalDateTime to) {
		this.interval = DateTimeInterval.of(from, to);
	}
	
	public List<DateTimeInterval> splitByDay() {
		return interval.splitByDay();
	}

	public Duration getDuration() {
		return interval.duration();
	}

	public LocalDateTime getFrom() {
		return interval.getFrom();
	}
	
	public LocalDateTime getTo() {
		return interval.getTo();
	}
	
	public DateTimeInterval getDateTimeInterval() {
		return interval;
	}

	@Override
	public String toString() {
		return "Call [interval=" + interval + "]";
	}
	
}
