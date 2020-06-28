package com.example.demo.chap08_의존성관리하기_영화예매.pricing;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.chap08_의존성관리하기_영화예매.DiscountCondition;
import com.example.demo.chap08_의존성관리하기_영화예매.DiscountPolicy;
import com.example.demo.chap08_의존성관리하기_영화예매.Screening;
import com.example.demo.money.Money;

public class OverlapperdDiscountPolicy extends DiscountPolicy {
	
	private List<DiscountPolicy> discountPolicies = new ArrayList<>();	

	public OverlapperdDiscountPolicy(List<DiscountPolicy> discountPolicies, 
			DiscountCondition... conditions) {
		super(conditions);
		this.discountPolicies = discountPolicies;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		Money result = Money.ZERO;
		for(DiscountPolicy each : discountPolicies) {
			result = result.plus(each.calculateDiscountAmount(screening));
		}
		return result;
	}
	

}
