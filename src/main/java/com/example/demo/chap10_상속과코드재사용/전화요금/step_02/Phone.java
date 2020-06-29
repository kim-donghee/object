package com.example.demo.chap10_상속과코드재사용.전화요금.step_02;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.money.Money;

public class Phone {
	private static final int LATE_NIGHT_HOUR = 22;
	enum PhoneType { REGULAR, NIGHTLY }
	
	private PhoneType type;
	
	private Money amount;
	private Money regularAmount;
	private Money nightlyAmount;
	
	private Duration seconds;
	
	private List<Call> calls = new ArrayList<>();

	public Phone(Money amount, Duration seconds) {
		this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
	}
	
	public Phone(Money nightlyAmount, Money regularAmount, Duration seconds) {
		this(PhoneType.NIGHTLY, Money.ZERO, regularAmount, nightlyAmount, seconds);
	}

	public Phone(PhoneType type, Money amount, Money regularAmount, Money nightlyAmount, Duration seconds) {
		this.type = type;
		this.amount = amount;
		this.regularAmount = regularAmount;
		this.nightlyAmount = nightlyAmount;
		this.seconds = seconds;
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
			if(type == PhoneType.REGULAR) {
				result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
			}
			else {
				if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
					result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
				}
				else {
					result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
				}
				
			}
		}
		return result;
	}

}
