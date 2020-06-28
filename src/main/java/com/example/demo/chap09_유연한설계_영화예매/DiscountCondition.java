package com.example.demo.chap09_유연한설계_영화예매;

public interface DiscountCondition {

	 boolean isSatisfiedBy(Screening screening);

}
