package com.example.demo.chap10_상속과코드재사용.뮤직플레이어;

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
