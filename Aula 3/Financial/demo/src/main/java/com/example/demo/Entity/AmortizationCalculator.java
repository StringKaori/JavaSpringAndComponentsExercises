package com.example.demo.Entity;

import com.example.demo.Repository.IAmortizationCalculator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AmortizationCalculator implements IAmortizationCalculator {

    private double value;
    private double rate;
    private int period;

    public void generate(double fixedInstallment) {
        double remainingBalance = value;

        System.out.println("==================================================");
        System.out.println("Amortization table");
        System.out.println("Fixed installment: " + fixedInstallment);
        System.out.println("==================================================");

        for (int i = 1; i <= period; i++) {
            double interest = remainingBalance * rate;
            double amortization = fixedInstallment - interest;
            remainingBalance -= amortization;

            System.out.println("Installment " + i + ":" +
                    "\nInterest: $" + formatDouble(interest) +
                    "\nAmortization: $" + formatDouble(amortization) +
                    "\nRemaining Balance: $" + formatDouble(remainingBalance));
                    
        System.out.println("==================================================");
        }
    }

    @Override
    public void update(double fixedInstallment) {
        this.generate(fixedInstallment);
    }

    // Mark : - Utils
    private String formatDouble(double value) {
        return String.format("%.2f", value);
    }
}

