package com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.pricing;

import com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.DiscountCondition;
import com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.DiscountPolicy;
import com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.Screening;
import com.example.demo.money.Money;

public class AmountDiscountPolicy extends DiscountPolicy {
	
	private Money discountMoney;

	public AmountDiscountPolicy(Money discountMoney, DiscountCondition... conditions) {
		super(conditions);
		this.discountMoney = discountMoney;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountMoney;
	}

}
