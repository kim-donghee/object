package com.example.demo.chap04_설계품질과트레이드오프_영화예매;

import com.example.demo.money.Money;

public class ReservationAgency {
	
	public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
		Money fee = screening.calculateFee(audienceCount);
		return new Reservation(customer, screening, fee, audienceCount);
	}

}
