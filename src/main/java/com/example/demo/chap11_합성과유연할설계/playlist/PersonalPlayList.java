package com.example.demo.chap11_합성과유연할설계.playlist;

public class PersonalPlayList {
	
	private PlayList playList;
	
	public void append(Song song) {
		playList.append(song);
	}
	
	public void remove(Song song) {
		playList.remove(song);
	}

}
