package com.example.demo.chap06_메시지와인터페이스_티켓;

public class Audience {
	private Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}
	
	public Long buy(Ticket ticket) {
		return bag.hold(ticket);
	}

}
