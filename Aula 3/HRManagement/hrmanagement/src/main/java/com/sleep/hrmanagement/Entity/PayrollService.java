package com.sleep.hrmanagement.Entity;

import com.sleep.hrmanagement.Repository.IPayrollService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class PayrollService implements IPayrollService {
    
    private int entry;
    private int exit;
    private double hourlyRate;

    public void emit(int workedHours) {
      System.out.println("\nWorked hours: " + workedHours);
      System.out.println("Payment: " + workedHours * hourlyRate);
    }

    @Override
    public void update(int workedHours) {
      this.emit(workedHours);
    }
}