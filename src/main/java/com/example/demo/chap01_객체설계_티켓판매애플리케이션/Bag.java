package com.example.demo.chap01_객체설계_티켓판매애플리케이션;

public class Bag {
	
	private Long amount;	// 현금
	
	private Invitation invitation;
	
	private Ticket ticket;
	
	public Bag(long amount) {
		this(null, amount);
	}
	
	public Bag(Invitation invitation, long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}
	
	public Long hold(Ticket ticket) {
		if(hasInvitation()) {
			setTicket(ticket);
			return 0L;
		}
		else {
			setTicket(ticket);
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}
	
	private boolean hasInvitation() {
		return invitation != null;
		
	}
	
	public boolean hasTicket() {
		return ticket != null;
	}
	
	private void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	private void minusAmount(Long amount) {
		this.amount -= amount;
	}
	
	public void plusAmount(Long amount) {
		this.amount += amount;
	}

}
