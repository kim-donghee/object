package com.example.demo.chap14_일관성있는협력.핸드폰요금.step02;

import java.util.List;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.time.DateTimeInterval;

public interface FeeCondition {
	
	List<DateTimeInterval> findTimeIntervals(Call call);

}
