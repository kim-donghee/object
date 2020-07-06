package com.example.demo.chap14_일관성있는협력.핸드폰요금.step01;

import java.time.Duration;

import com.example.demo.money.Money;

public class FixedFeePolicy extends BasicRatePolicy {
	
	private Money amount;
	
	private Duration duration;
	
	public FixedFeePolicy(Money amount, Duration duration) {
		this.amount = amount;
		this.duration = duration;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times(call.getDuration().getSeconds() / duration.getSeconds());
	}

}
