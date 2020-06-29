package com.example.demo.chap10_상속과코드재사용.전화요금.step_04;

import java.time.Duration;

import com.example.demo.money.Money;

public class RegularPhone extends Phone {

	private Money amount;

	private Duration seconds;

	public RegularPhone(Money amount, Duration seconds, double taxRate) {
		super(taxRate);
		this.amount = amount;
		this.seconds = seconds;
	}
	
	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
	}

}
