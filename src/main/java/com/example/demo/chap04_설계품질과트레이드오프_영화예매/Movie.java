package com.example.demo.chap04_설계품질과트레이드오프_영화예매;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.example.demo.money.Money;

public class Movie {

	private String title;
	private Duration runningTime;
	private Money fee;
	private List<DiscountCondition> discountConditions;

	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;

	public Movie(String title, Duration runningTime, Money fee, double discountPercent,
			DiscountCondition... discountConditions) {
		this(MovieType.PERCENT_DISCOUNT, title, runningTime, fee, Money.ZERO, discountPercent, discountConditions);
	}

	public Movie(String title, Duration runningTime, Money fee, Money discountAmount,
			DiscountCondition... discountConditions) {
		this(MovieType.AMOUNT_DISCOUNT, title, runningTime, fee, discountAmount, 0, discountConditions);
	}

	public Movie(String title, Duration runningTime, Money fee) {
		this(MovieType.NONE_DISCOUNT, title, runningTime, fee, Money.ZERO, 0);
	}

	public Movie(MovieType movieType, String title, Duration runningTime, Money fee, Money discountAmount,
			double discountPercent, DiscountCondition... discountConditions) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountConditions = Arrays.asList(discountConditions);
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public Money calculateAmountDiscountFee() {
		if (movieType != MovieType.AMOUNT_DISCOUNT) {
			throw new IllegalArgumentException();
		}
		return fee.minus(discountAmount);
	}

	public Money calculatePercentDiscountFee() {
		if (movieType != MovieType.PERCENT_DISCOUNT) {
			throw new IllegalArgumentException();
		}
		return fee.minus(fee.times(discountPercent));
	}

	public Money calculateNoneDiscountedFee() {
		if (movieType != MovieType.NONE_DISCOUNT) {
			throw new IllegalArgumentException();
		}

		return fee;
	}

	public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
		for (DiscountCondition discountCondition : discountConditions) {
			if (discountCondition.getType() == DiscountConditionType.PERIOD) {
				if (discountCondition.isDescountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
					return true;
				}
			} else {
				if (discountCondition.isDiscountable(sequence)) {
					return true;
				}
			}
		}
		return false;
	}

}
