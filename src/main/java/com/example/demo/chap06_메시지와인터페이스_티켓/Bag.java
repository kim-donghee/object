package com.example.demo.chap06_메시지와인터페이스_티켓;

public class Bag {
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public Bag(long amount) {
		this(null, amount);
	}

	public Bag(Invitation invitation, long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}

	public boolean hasInvitation() {
		return invitation != null;
	}

	public boolean hasTicket() {
		return ticket != null;
	}

	public Long hold(Ticket ticket) {
		if(hasInvitation()) {
			this.ticket = ticket;
			return 0L;
		}
		else {
			this.ticket = ticket;
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long sell) {
		this.amount += amount;
	}
}
