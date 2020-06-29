package com.example.demo.chap10_상속과코드재사용.뮤직플레이어;

public class PersonalPlayList extends PlayList {
	
	public void remove(Song song) {
		getTracks().remove(song);
		getSingers().remove(song.getSinger());
	}

}
