package com.example.demo.chap09_유연한설계_영화예매.locator;

import com.example.demo.chap09_유연한설계_영화예매.DiscountPolicy;

public class ServiceLocator {
	
	private static ServiceLocator soleInstance = new ServiceLocator();

	private DiscountPolicy discountPolicy;
	
	public static DiscountPolicy discountPolicy() {
		return soleInstance.discountPolicy;
	}
	
	public static void provide(DiscountPolicy discountPolicy) {
		soleInstance.discountPolicy = discountPolicy;
	}
	
	private ServiceLocator() { }
	
}
