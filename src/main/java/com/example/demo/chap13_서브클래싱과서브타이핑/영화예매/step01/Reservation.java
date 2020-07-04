package com.example.demo.chap13_서브클래싱과서브타이핑.영화예매.step01;

import com.example.demo.money.Money;

public class Reservation {
	private Customer customer;
    private Screening Screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening Screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.Screening = Screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
