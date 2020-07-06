package com.example.demo.chap14_일관성있는협력.핸드폰요금.step02;

import com.example.demo.money.Money;

public interface RatePolicy {
	
	Money calculateFee(Phone phone);

}
