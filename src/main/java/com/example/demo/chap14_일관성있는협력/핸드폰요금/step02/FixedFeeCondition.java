package com.example.demo.chap14_일관성있는협력.핸드폰요금.step02;

import java.util.Arrays;
import java.util.List;

import com.example.demo.chap14_일관성있는협력.핸드폰요금.time.DateTimeInterval;

public class FixedFeeCondition implements FeeCondition {
    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
    	return Arrays.asList(call.getDateTimeInterval());
    }

}
