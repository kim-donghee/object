package com.example.demo.chap11_합성과유연할설계.billing.step01;

import java.time.Duration;

import com.example.demo.money.Money;

public class RegularPhone extends Phone {
	private Money amount;
	private Duration seconds;

	public RegularPhone(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
	}
	
}
