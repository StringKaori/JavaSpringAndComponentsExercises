package com.sleep.ecommerce.Entity;

import com.sleep.ecommerce.Repository.IOrderPurchaseService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class OrderPurchaseService implements IOrderPurchaseService {

    private int orderQuantity;
    private int stockBalance;

    public void performPurchase(boolean hasAvailableStock) {        
        if (hasAvailableStock) {
            stockBalance -= orderQuantity;

            System.out.println("Order completed successfully.");
            System.out.println("Stock updated, Remaining stock quantity: " + stockBalance);
        }
    } 

    @Override
    public void update(boolean hasAvailableStock) {
        performPurchase(hasAvailableStock);
    }
}