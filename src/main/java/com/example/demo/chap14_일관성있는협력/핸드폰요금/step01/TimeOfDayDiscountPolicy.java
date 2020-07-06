package com.example.demo.chap14_일관성있는협력.핸드폰요금.step01;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.time.DateTimeInterval;
import com.example.demo.money.Money;

public class TimeOfDayDiscountPolicy extends BasicRatePolicy {
	
	private List<LocalTime> starts = new ArrayList<>();
	private List<LocalTime> ends = new ArrayList<>();
	private List<Duration> durations = new ArrayList<>();
	private List<Money> amounts = new ArrayList<>();

	@Override
	protected Money calculateCallFee(Call call) {
		Money result = Money.ZERO;
		
		for(DateTimeInterval interval : call.splitByDay()) {
			for(int loop=0; loop < starts.size(); loop++) {
				result.plus(amounts.get(loop).times(
						Duration.between(from(interval, starts.get(loop)), to(interval, ends.get(loop)))
							.getSeconds() / durations.get(loop).getSeconds()));
				System.out.println(loop);
			}
			System.out.println(interval);
		}
		
		return result;
	}
	
	private LocalTime from(DateTimeInterval interval, LocalTime from) {
		LocalTime invervalFromTime = interval.getFrom().toLocalTime();
		return invervalFromTime.isBefore(from) ?
				from : invervalFromTime;
	}
	
	private LocalTime to(DateTimeInterval interval, LocalTime to) {
		LocalTime invervalToTime = interval.getTo().toLocalTime();
		return invervalToTime.isAfter(to) ?
				to : invervalToTime;
	}

}
