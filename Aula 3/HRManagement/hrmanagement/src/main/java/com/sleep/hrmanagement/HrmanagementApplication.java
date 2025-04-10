package com.sleep.hrmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sleep.hrmanagement.Entity.PayrollService;
import com.sleep.hrmanagement.Entity.WorkedHoursCalculator;

@SpringBootApplication
public class HrmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmanagementApplication.class, args);
		int entry = 9;
        int exit = 18;
        double hourlyRate = 20;

		WorkedHoursCalculator workedHoursCalculator = new WorkedHoursCalculator();
		workedHoursCalculator.connect(new PayrollService(entry, exit, hourlyRate));
	
	}

}
