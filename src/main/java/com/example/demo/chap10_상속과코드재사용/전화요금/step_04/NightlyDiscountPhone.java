package com.example.demo.chap10_상속과코드재사용.전화요금.step_04;

import java.time.Duration;

import com.example.demo.money.Money;

public class NightlyDiscountPhone extends Phone {
	
	private static final int LATE_LIGHT_HOUR = 22;
	
	private Money nightlyAmount;
	
	private Money regularAmount;
	
	private Duration seconds;
	
	public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
		super(taxRate);
		this.nightlyAmount = nightlyAmount;
		this.regularAmount = regularAmount;
		this.seconds = seconds;
	}
	
	@Override
	protected Money calculateCallFee(Call call) {
		if(call.getFrom().getHour() > LATE_LIGHT_HOUR) {
			return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
		}
		else {
			return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
		}
	}
	
}
