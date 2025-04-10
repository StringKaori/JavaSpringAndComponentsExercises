package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Entity.AmortizationCalculator;
import com.example.demo.Entity.CompoundInterestCalculator;

@SpringBootApplication
public class FinancialApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialApplication.class, args);

		double value = 10000;
        double rate = 0.1;
        int period = 18;

		CompoundInterestCalculator interestCalculator = new CompoundInterestCalculator();
		interestCalculator.connect(new AmortizationCalculator(value, rate, period));
	}

}