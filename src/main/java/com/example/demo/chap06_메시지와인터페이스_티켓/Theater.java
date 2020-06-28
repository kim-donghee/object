package com.example.demo.chap06_메시지와인터페이스_티켓;

public class Theater {
	
	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}
	
	public void enter(Audience audience) {
		ticketSeller.sellTo(audience);
	}
	
}
