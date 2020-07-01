package com.example.demo.chap11_합성과유연할설계.billing.step01;

import java.time.Duration;

import com.example.demo.money.Money;

public class RateDiscountableRegularPhone extends RegularPhone {
    private Money discountAmount;

    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }

}
