package com.example.demo.chap02_객체지향프로그래밍_영화예매.movie;

import com.example.demo.money.Money;

public class Reservation {
	
	private Customer customer;
	
	private Screening screening;
	
	private Money fee;
	
	private int audienceCount;
	
	public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
		this.customer = customer;
		this.screening = screening;
		this.fee = fee;
		this.audienceCount = audienceCount;
	}

}
