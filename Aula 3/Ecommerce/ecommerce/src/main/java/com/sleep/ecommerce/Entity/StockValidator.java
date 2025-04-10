package com.sleep.ecommerce.Entity;

import com.sleep.ecommerce.Repository.IStockValidator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class StockValidator implements IStockValidator {    
    public boolean validateStockQuantity(int orderQuantity, int stockBalance) {
        System.out.println("\nOrder quantity: " + orderQuantity);
        System.out.println("Current stock: " + stockBalance);

        if (orderQuantity <= stockBalance) { return true; };

        System.err.println("Insufficient stock: The order can't be processed.");

        return false;
    }

    @Override
    public void connect(OrderPurchaseService orderPurchaseService) {
        orderPurchaseService.update(validateStockQuantity(orderPurchaseService.getOrderQuantity(), orderPurchaseService.getStockBalance()));
    }
}