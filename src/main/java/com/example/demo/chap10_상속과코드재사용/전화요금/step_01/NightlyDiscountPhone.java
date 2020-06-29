package com.example.demo.chap10_상속과코드재사용.전화요금.step_01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.money.Money;

public class NightlyDiscountPhone {
	
	private static final int LATE_LIGHT_HOUR = 22;
	
	private Money nightlyAmount;
	
	private Money regularAmount;
	
	private Duration seconds;
	
	private double taxRate;
	
	private List<Call> calls = new ArrayList<>();
	
	public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
		this.nightlyAmount = nightlyAmount;
		this.regularAmount = regularAmount;
		this.seconds = seconds;
		this.taxRate = taxRate;
	}
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		for(Call call : calls) {
			if(call.getFrom().getHour() > LATE_LIGHT_HOUR) {
				result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
			}
			else {
				result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
			}
		}
		return result.plus(result.times(taxRate));
	}
	
}
