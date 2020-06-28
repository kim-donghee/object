package com.example.demo.chap06_메시지와인터페이스_티켓.일정관리;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
	
	private String subject;
	
	private LocalDateTime from;
	
	private Duration duration;

	public Event(String subject, LocalDateTime from, Duration duration) {
		this.subject = subject;
		this.from = from;
		this.duration = duration;
	}
	
	public boolean isSatisfied(RecurringSchedule recurringSchedule) {
		if(!from.getDayOfWeek().equals(recurringSchedule.getDayOfWeek()) ||
				!from.toLocalTime().equals(recurringSchedule.getFrom()) ||
				!duration.equals(recurringSchedule.getDuration())) {
			return false;
		}
		return true;
	}

	public void reschedule(RecurringSchedule recurringSchedule) {
		from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(recurringSchedule))
				, recurringSchedule.getFrom());
		duration = recurringSchedule.getDuration();
	}

	private long daysDistance(RecurringSchedule recurringSchedule) {
		return recurringSchedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
	}

}
