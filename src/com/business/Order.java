package com.business;

import com.dao.OrderRepository;
import java.io.IOException;
import java.util.ArrayList;

public class Order extends RegistrableObject {
    private ArrayList<OrderItem> products;
    private String customerCpf;

    public Order(ArrayList<OrderItem> products, String customerCpf) {
        if(products.isEmpty() || customerCpf.isEmpty())
            throw new IllegalArgumentException("Value cannot be empty.");
        this.products = products;
        this.customerCpf = customerCpf;
    }

    @Override
    public void register(RegistrableObject obj) throws IOException {
        OrderRepository repository = new OrderRepository();
        repository.registerOrder((Order) obj);
    }

    @Override
    public String toString() {
        StringBuilder initial = new StringBuilder(System.identityHashCode(this) + "|" + customerCpf);
        for (OrderItem item : products) {
            initial.append("|").append(item.toString());
        }
        return initial.toString();
    }


}
