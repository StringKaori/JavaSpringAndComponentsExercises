package com.sleep.ecommerce.Repository;

import com.sleep.ecommerce.Entity.OrderPurchaseService;

public interface IStockValidator {
    public void connect(OrderPurchaseService orderPurchaseService);
}