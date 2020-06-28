package com.example.demo.chap01_객체설계_티켓판매애플리케이션;

public class TicketSeller {
	
	private TicketOffice ticketOffice;
	
	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}
	
//	public TicketOffice getTicketOffice() {
//		return this.ticketOffice;
//	}
	public void sellTo(Audience audience) {
//		if(audience.getBag().hasInvitation()) {
//			Ticket ticket = ticketOffice.getTicket();
//			audience.getBag().setTicket(ticket);
//		}
//		else {
//			Ticket ticket = ticketOffice.getTicket();
//			audience.getBag().minusAmount(ticket.getFee());
//			ticketOffice.plusAmount(ticket.getFee());
//			audience.getBag().setTicket(ticket);
//		}
		
		ticketOffice.sellTicketTo(audience);
		
	}

}
