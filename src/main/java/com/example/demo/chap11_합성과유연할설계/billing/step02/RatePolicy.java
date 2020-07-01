package com.example.demo.chap11_합성과유연할설계.billing.step02;

import com.example.demo.money.Money;

public interface RatePolicy {
	
	Money calculateFee(Phone phone);

}
