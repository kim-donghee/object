package com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.pricing;

import com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.DiscountCondition;
import com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01.Screening;

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
