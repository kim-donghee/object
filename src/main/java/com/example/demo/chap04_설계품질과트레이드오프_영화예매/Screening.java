package com.example.demo.chap04_설계품질과트레이드오프_영화예매;

import java.time.LocalDateTime;

import com.example.demo.money.Money;

public class Screening {
	
	private Movie movie;
	
	private int sequence;
	
	private LocalDateTime whenScreened;

	public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}
	
	public Money calculateFee(int audienceCount) {
		switch (movie.getMovieType()) {
		case AMOUNT_DISCOUNT:
			if(movie.isDiscountable(whenScreened, sequence)) {
				return movie.calculateAmountDiscountFee().times(audienceCount);
			}
		case PERCENT_DISCOUNT:
			if(movie.isDiscountable(whenScreened, sequence)) {
				return movie.calculatePercentDiscountFee().times(audienceCount);
			}
		case NONE_DISCOUNT:
			return movie.calculateNoneDiscountedFee();
		}
		
		return movie.calculateNoneDiscountedFee().times(audienceCount);
	}
	
}
