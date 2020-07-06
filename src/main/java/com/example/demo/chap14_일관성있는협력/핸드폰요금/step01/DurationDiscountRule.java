package com.example.demo.chap14_일관성있는협력.핸드폰요금.step01;

import java.time.Duration;

import com.example.demo.money.Money;

public class DurationDiscountRule extends FixedFeePolicy {

	private Duration from;

	private Duration to;

	public DurationDiscountRule(Duration from, Duration to, Money amount, Duration secondes) {
		super(amount, secondes);
		this.from = from;
		this.to = to;
	}

	public Money calculate(Call call) {
		System.out.println(String.format("call.getDuration() : %d, to.getSeconds() : %d, from.getSeconds() : %d",
				call.getDuration().getSeconds(), to.getSeconds(), from.getSeconds()));
//		if (call.getDuration().compareTo(to) > 0) {
//			return Money.ZERO;
//		}
//
//		if (call.getDuration().compareTo(from) < 0) {
//			return Money.ZERO;
//		}

		// 부모 클래스의 calculateFee(phone)은 Phone 클래스를 파라미터로 받는다.
		// calculateFee(phone)을 재사용하기 위해 데이터를 전달할 용도로 임시 Phone을 만든다.
		Phone phone = new Phone(null);
		phone.call(new Call(call.getFrom().plus(from),
				call.getDuration().compareTo(to) > 0 ? call.getFrom().plus(to) : call.getTo()));
		
		return super.calculateFee(phone);
	}

}
