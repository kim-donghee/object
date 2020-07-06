package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.step01.Call;
import com.example.demo.chap14_일관성있는협력.핸드폰요금.step01.DurationDiscountPolicy;
import com.example.demo.chap14_일관성있는협력.핸드폰요금.step01.DurationDiscountRule;
import com.example.demo.chap14_일관성있는협력.핸드폰요금.step01.FixedFeePolicy;
import com.example.demo.chap14_일관성있는협력.핸드폰요금.step01.Phone;
import com.example.demo.chap14_일관성있는협력.핸드폰요금.step01.TimeOfDayDiscountPolicy;
import com.example.demo.money.Money;

@SpringBootTest
class ObjectApplicationTests {

	@Test
	void contextLoads() {
		LocalDate toDay = LocalDate.now(); 
		
		LocalDateTime from = LocalDateTime.of(LocalDate.of(2020, 01, 01), LocalTime.of(10, 00));
		LocalDateTime to = LocalDateTime.of(LocalDate.of(2020, 01, 03), LocalTime.of(15, 00));
		
		assertEquals(Period.between(toDay, toDay).getDays(), 0);
		assertEquals(Period.between(toDay.minusDays(1), toDay).getDays(), 1);

		assertEquals(Period.between(from.toLocalDate(), to.toLocalDate()).getDays(), 2);
		
		Phone phone = new Phone(new TimeOfDayDiscountPolicy());
		phone.call(new Call(from, to));
		System.out.println(phone.calculateFee());

		List<DurationDiscountRule> durationRules = new ArrayList<>();
		durationRules.add(new DurationDiscountRule(
				Duration.ofMinutes(0), Duration.ofMinutes(10), Money.wons(10), Duration.ofSeconds(10)));
		durationRules.add(new DurationDiscountRule(
				Duration.ofMinutes(10), Duration.ofMinutes(20), Money.wons(8), Duration.ofSeconds(10)));
		durationRules.add(new DurationDiscountRule(
				Duration.ofMinutes(20), Duration.ofMinutes(Integer.MAX_VALUE), Money.wons(5), Duration.ofSeconds(10)));
		Phone phone2 = new Phone(new DurationDiscountPolicy(durationRules));
		phone2.call(new Call(LocalDateTime.now(), LocalDateTime.now().plusMinutes(25)));
		System.out.println(phone2.calculateFee());
		
		Phone phone3 = new Phone(new FixedFeePolicy(Money.wons(10), Duration.ofSeconds(10)));
		phone3.call(new Call(LocalDateTime.now(), LocalDateTime.now().plusMinutes(25)));
		System.out.println(phone3.calculateFee());
	}

}
