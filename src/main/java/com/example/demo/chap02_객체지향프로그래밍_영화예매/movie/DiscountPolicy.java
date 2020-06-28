package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie;

import com.example.demo.money.Money;

public interface DiscountPolicy {
	
	Money calculateDiscountAmount(Screening screening);

}
