package com.example.demo.chap08_의존성관리하기_영화예매.pricing;

import com.example.demo.chap08_의존성관리하기_영화예매.DiscountCondition;
import com.example.demo.chap08_의존성관리하기_영화예매.Screening;

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
