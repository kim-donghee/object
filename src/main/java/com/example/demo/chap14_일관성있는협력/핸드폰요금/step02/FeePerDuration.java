package com.example.demo.chap14_일관성있는협력.핸드폰요금.step02;

import java.time.Duration;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.time.DateTimeInterval;
import com.example.demo.money.Money;

public class FeePerDuration {
	
	private Money fee;
	
	private Duration duration;

	public FeePerDuration(Money fee, Duration duration) {
		this.fee = fee;
		this.duration = duration;
	}
	
	public Money calculate(DateTimeInterval interval) {
		return fee.times(interval.duration().getSeconds() / duration.getSeconds());
	}

}
