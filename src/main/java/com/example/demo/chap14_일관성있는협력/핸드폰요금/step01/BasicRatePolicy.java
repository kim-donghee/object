package com.example.demo.chap14_일관성있는협력.핸드폰요금.step01;

import com.example.demo.money.Money;

public abstract class BasicRatePolicy implements RatePolicy {

	@Override
	public Money calculateFee(Phone phone) {
		Money result = Money.ZERO;

		for (Call call : phone.getCalls()) {
			result = result.plus(calculateCallFee(call));
		}

		return result;
	}

	protected abstract Money calculateCallFee(Call call);

}
