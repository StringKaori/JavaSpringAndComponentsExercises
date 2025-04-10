package com.sleep.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sleep.ecommerce.Entity.OrderPurchaseService;
import com.sleep.ecommerce.Entity.StockValidator;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);

		int stockBalance = 999;
        int orderQuantity = 9;

		StockValidator stockValidator = new StockValidator();
		stockValidator.connect(new OrderPurchaseService(orderQuantity, stockBalance));
	}
}