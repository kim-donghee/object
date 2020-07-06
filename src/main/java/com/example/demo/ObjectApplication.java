package com.example.demo;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.chap06_메시지와인터페이스_티켓.일정관리.Event;
import com.example.demo.chap06_메시지와인터페이스_티켓.일정관리.RecurringSchedule;
import com.example.demo.chap14_일관성있는협력.핸드폰요금.step01.DurationDiscountPolicy;

@SpringBootApplication
public class ObjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObjectApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner applicationRunner() {
		return new ApplicationRunner() {
			
			@Override
			public void run(ApplicationArguments args) throws Exception {
				Event event = new Event("회의", LocalDateTime.of(2020, 06, 25, 7, 0), Duration.ofHours(30));
				
				RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.FRIDAY, 
						LocalTime.of(7, 30), Duration.ofHours(30));
				
//				System.out.println(event.isSatisfied(schedule));
//				System.out.println(event.isSatisfied(schedule));
				
			}
		};
	}

}
