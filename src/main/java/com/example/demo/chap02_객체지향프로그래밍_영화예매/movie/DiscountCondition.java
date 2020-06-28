package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie;

public interface DiscountCondition {

	boolean isSatisfiedBy(Screening screening);

}
