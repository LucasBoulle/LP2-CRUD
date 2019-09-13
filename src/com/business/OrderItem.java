package com.business;

import java.io.IOException;

public class OrderItem {
    private String sku ;
    private int amount;

    public OrderItem(String sku, int amount) {
        this.sku = sku;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return sku + "," + amount;
    }


}
