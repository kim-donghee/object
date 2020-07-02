package com.example.demo.chap12_다형성.lecture.step02;

public class Professor {
	
	private String name;
	
	private Lecture lecture;
	
	public Professor(String name, Lecture lecture) {
		this.name = name;
		this.lecture = lecture;
	}
	
	public String complieStatistics() {
		return String.format("[%s] %s - Avg: %.1f", name,
                lecture.evaluate(), lecture.average());
	}

}
