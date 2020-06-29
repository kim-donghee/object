package com.example.demo.chap10_상속과코드재사용.전화요금.step_04;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.money.Money;

public abstract class Phone {

	private List<Call> calls = new ArrayList<>();

	private double taxRate;

	public Phone(double taxRate) {
		this.taxRate = taxRate;
	}

	public Money calculateFee() {
		Money result = Money.ZERO;
		for (Call call : calls) {
			result = result.plus(calculateCallFee(call));
		}
		return result.plus(result.times(taxRate));
	}

	abstract protected Money calculateCallFee(Call call);

}
