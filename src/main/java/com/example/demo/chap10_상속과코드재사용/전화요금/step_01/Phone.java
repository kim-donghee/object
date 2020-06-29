package com.example.demo.chap10_상속과코드재사용.전화요금.step_01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.money.Money;

public class Phone {
	
	private Money amount;
	
	private Duration seconds;
	
	private double taxRate;
	
	private List<Call> calls = new ArrayList<>();

	public Phone(Money amount, Duration seconds, double taxRate) {
		this.amount = amount;
		this.seconds = seconds;
		this.taxRate = taxRate;
	}

	public Money getAmount() {
		return amount;
	}

	public Duration getSeconds() {
		return seconds;
	}

	public List<Call> getCalls() {
		return calls;
	}
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		for(Call call : calls) {
			result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
		}
		return result.plus(result.times(taxRate));
	}

}
