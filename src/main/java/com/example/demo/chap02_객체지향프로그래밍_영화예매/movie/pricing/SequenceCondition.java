package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.pricing;

import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.DiscountCondition;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.Screening;

public class SequenceCondition implements DiscountCondition {

	private int sequence;
	
	public SequenceCondition(int sequence) {
		this.sequence = sequence;
	}
	
	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.isSequence(sequence);
	}

}
