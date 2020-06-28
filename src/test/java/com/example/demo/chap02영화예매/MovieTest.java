package com.example.demo.chap02영화예매;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.Customer;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.Movie;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.Screening;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.pricing.AmountDiscountPolicy;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.pricing.NoneDiscountPolicy;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.pricing.PeriodCondition;
import com.example.demo.chap02_객체지향프로그래밍_영화예매.movie.pricing.SequenceCondition;
import com.example.demo.money.Money;

public class MovieTest {
	
	@Test
	void 영화테스트() {
		Customer customer = new Customer("홍길도", "1");
		
		Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000), 
				new AmountDiscountPolicy(Money.wons(800), 
						new SequenceCondition(2),
						new SequenceCondition(10),
						new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
						new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
						));
		
		Screening screening = new Screening(avatar, 1, LocalDateTime.of(2020, 6, 15, 11, 0));
		screening.reserve(customer, 5);
		
		Movie startWars = new Movie("스타워즈", Duration.ofMinutes(120), Money.wons(10000), 
				new NoneDiscountPolicy());
		
		Screening screening2 = new Screening(startWars, 1, LocalDateTime.of(2020, 6, 15, 11, 0));
		screening2.reserve(customer, 5);
		
		System.out.println(startWars.getFee());
		
		
	}

}
