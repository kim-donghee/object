package com.example.demo.chap09_유연한설계_영화예매.factory;

import java.time.Duration;

import com.example.demo.chap09_유연한설계_영화예매.Movie;
import com.example.demo.chap09_유연한설계_영화예매.pricing.AmountDiscountPolicy;
import com.example.demo.chap09_유연한설계_영화예매.pricing.SequenceCondition;
import com.example.demo.money.Money;

public class Factory {
	
	public Movie createAvatarMovie() {
		return new Movie("아바타",
				Duration.ofMinutes(120),
				Money.wons(10000),
				new AmountDiscountPolicy(Money.wons(800), 
						new SequenceCondition(1),
						new SequenceCondition(10)));
	}

}
