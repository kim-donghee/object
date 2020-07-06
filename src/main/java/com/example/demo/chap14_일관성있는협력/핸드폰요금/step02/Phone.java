package com.example.demo.chap14_일관성있는협력.핸드폰요금.step02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.money.Money;

public class Phone {
	private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }
    
    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
