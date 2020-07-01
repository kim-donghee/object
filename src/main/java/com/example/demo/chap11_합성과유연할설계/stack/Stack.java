package com.example.demo.chap11_합성과유연할설계.stack;

import java.util.EmptyStackException;
import java.util.Vector;

public class Stack<E> {
	
	private Vector<E> elements = new Vector<>();
	
	public E push(E item) {
		elements.addElement(item);
		return item;
	}
	
	public E pop() {
		if(elements.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return elements.remove(elements.size() - 1);
	}
	
}
