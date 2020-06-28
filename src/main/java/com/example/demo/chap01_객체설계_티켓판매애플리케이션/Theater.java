package com.example.demo.chap01_객체설계_티켓판매애플리케이션;

public class Theater {
	
	private TicketSeller ticketSeller;
	
	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}
	
	public void enter(Audience audience) {
//		if(audience.getBag().hasInvitation()) {
//			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//			audience.getBag().setTicket(ticket);
//		}
//		else {
//			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//			audience.getBag().minusAmount(ticket.getFee());
//			ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
//			audience.getBag().setTicket(ticket);
//		}
		
		ticketSeller.sellTo(audience);
		
	}

}
