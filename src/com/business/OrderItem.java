package com.business;

public class OrderItem {
    private String sku ;
    private int amount;

    public OrderItem(String sku, int amount) {
        if(sku.isEmpty())
            throw new IllegalArgumentException("Value cannot be empty.");
        this.sku = sku;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return sku + "," + amount;
    }


}
