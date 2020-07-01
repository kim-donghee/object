package com.example.demo.chap11_합성과유연할설계.billing.step01;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.money.Money;

public abstract class Phone {
	private List<Call> calls = new ArrayList<>();

	public Money calculateFee() {
		Money result = Money.ZERO;

		for (Call call : calls) {
			result = result.plus(calculateCallFee(call));
		}

		return afterCalculated(result);
	}
	
	protected Money afterCalculated(Money fee) {
		return fee;
	}

	abstract protected Money calculateCallFee(Call call);
}
