package com.example.demo.chap10_상속과코드재사용.전화요금.step_03;

import java.time.Duration;

import com.example.demo.money.Money;

public class NightlyDiscountPhone extends Phone {
	
	private static final int LATE_LIGHT_HOUR = 22;
	
	private Money nightlyAmount;
	
	public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
		super(regularAmount, seconds, taxRate);
		this.nightlyAmount = nightlyAmount;
	}
	
	public Money calculateFee() {
		Money result = super.calculateFee();
		
		Money nightlyFee = Money.ZERO;
		for(Call call : getCalls()) {
			if(call.getFrom().getHour() >= LATE_LIGHT_HOUR) {
				nightlyFee = nightlyFee.plus(
						getAmount()
							.minus(nightlyAmount)
							.times(call.getDuration().getSeconds() / getSeconds().getSeconds()));
			}
		}
		
		return result.minus(nightlyFee.plus(nightlyFee.times(getTaxRate())));
	}
	
}
