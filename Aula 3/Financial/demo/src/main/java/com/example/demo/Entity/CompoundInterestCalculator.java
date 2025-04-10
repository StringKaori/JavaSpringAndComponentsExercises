package com.example.demo.Entity;

import com.example.demo.Repository.ICompoundInterestCalculator;

public class CompoundInterestCalculator implements ICompoundInterestCalculator {
    public double calculate(double value, double rate, int period) {
        return value * (rate * Math.pow(1 + rate, period)) / (Math.pow(1 + rate, period) - 1);
    }

    public void connect(AmortizationCalculator component) {
        component.update(calculate(component.getValue(), component.getRate(), component.getPeriod()));
    }
}