package com.example.demo.chap11_합성과유연할설계.billing.step02;

import com.example.demo.money.Money;

public abstract class BasicRatePolicy implements RatePolicy {
	
	@Override
	public Money calculateFee(Phone phone) {
		Money result = Money.ZERO;
		
		for(Call call : phone.getCalls()) {
			result.plus(calculateCallFee(call));
		}
		
		return result;
	}

	protected abstract Money calculateCallFee(Call call);

}
