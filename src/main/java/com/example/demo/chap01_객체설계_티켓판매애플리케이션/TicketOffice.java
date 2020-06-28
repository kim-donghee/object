package com.example.demo.chap01_객체설계_티켓판매애플리케이션;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
	
	private Long amount;
	
	private List<Ticket> ticekts = new ArrayList<>();
	
	public TicketOffice(Long amount, Ticket ...tickets) {
		this.amount = amount;
		this.ticekts.addAll(ticekts);
	}
	
	public void sellTicketTo(Audience audience) {
		plusAmount(audience.buy(getTicket()));
	}
	
	private Ticket getTicket() {
		return this.ticekts.remove(0);
	}
	
	public void minusAmount(Long amount) {
		this.amount -= amount;
	}
	
	private void plusAmount(Long amount) {
		this.amount += amount;
	}

}
