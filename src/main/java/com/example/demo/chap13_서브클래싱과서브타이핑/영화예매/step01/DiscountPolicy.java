package com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.money.Money;

public abstract class DiscountPolicy {
	private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        checkPrecondition(screening);

        Money amount = Money.ZERO;
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                amount = getDiscountAmount(screening);
                checkPostcondition(amount);
                return amount;
            }
        }

        amount = screening.getMovieFee();
        checkPostcondition(amount);
        return amount;
    }

    protected void checkPrecondition(Screening screening) {
        assert screening != null &&
                screening.getStartTime().isAfter(LocalDateTime.now());
    }

    protected void checkPostcondition(Money amount) {
        assert amount != null && amount.isGreaterThanOrEquals(Money.ZERO);
    }


    abstract protected Money getDiscountAmount(Screening Screening);
}
