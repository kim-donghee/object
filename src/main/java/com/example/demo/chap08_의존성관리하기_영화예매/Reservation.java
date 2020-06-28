package com.example.demo.chap08_의존성관리하기_영화예매;

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
