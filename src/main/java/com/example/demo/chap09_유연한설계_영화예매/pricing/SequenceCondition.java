package com.example.demo.chap09_유연한설계_영화예매.pricing;

import com.example.demo.chap09_유연한설계_영화예매.DiscountCondition;
import com.example.demo.chap09_유연한설계_영화예매.Screening;

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
