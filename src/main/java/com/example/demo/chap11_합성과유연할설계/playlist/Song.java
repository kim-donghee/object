package com.example.demo.chap11_합성과유연할설계.playlist;

public class Song {
	private String singer;
	private String title;

	public Song(String singer, String title) {
		this.singer = singer;
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public String getTitle() {
		return title;
	}
}
