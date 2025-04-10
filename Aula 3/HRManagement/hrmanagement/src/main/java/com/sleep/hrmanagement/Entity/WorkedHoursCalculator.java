package com.sleep.hrmanagement.Entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

import com.sleep.hrmanagement.Repository.IWorkedHoursCalculator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class WorkedHoursCalculator implements IWorkedHoursCalculator {
    public int calculate(int entry, int exit) {
        if (exit < entry) exit += 24;
        
        int dailyHours = (exit - entry) - 1;
        int totalHours = 0;

		YearMonth currentYearMonth = YearMonth.now();
		int year = currentYearMonth.getYear();
		int month = currentYearMonth.getMonthValue();

        for (int day = 1; day <= LocalDate.of(year, month, 1).lengthOfMonth(); day++) {
            LocalDate date = LocalDate.of(year, month, day);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) totalHours += dailyHours; // sábados e domingos compensados
        }

        return totalHours;
    }

    @Override
    public void connect(PayrollService component) {
        component.update(calculate(component.getEntry(), component.getExit()));
    }
}