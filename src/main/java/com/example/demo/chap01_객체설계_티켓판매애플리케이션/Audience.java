package com.example.demo.chap01_객체설계_티켓판매애플리케이션;

public class Audience {
	
	private Bag bag;
	
	public Audience(Bag bag) {
		this.bag = bag;
	}
	
	public Long buy(Ticket ticket) {
		return bag.hold(ticket);
	}
	
}
