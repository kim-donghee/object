package com.example.demo.chap10_상속과코드재사용.전화요금.step_02;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
	
	private LocalDateTime from;
	
	private LocalDateTime to;

	public Call(LocalDateTime from, LocalDateTime to) {
		this.from = from;
		this.to = to;
	}
	
	public Duration getDuration() {
		return Duration.between(from, to);
	}

	public LocalDateTime getFrom() {
		return from;
	}

}
