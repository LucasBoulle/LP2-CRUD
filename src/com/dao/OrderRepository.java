package com.dao;

import com.business.Order;
import com.business.Product;
import com.commons.enums.EnumDataRepositoryPath;

import java.io.IOException;
import java.util.Arrays;

public class OrderRepository {
    public void registerOrder(Order order) throws IOException {
        RepositoryActions actions = new RepositoryActions();
        actions.writeFile(
                EnumDataRepositoryPath.Order.getPath(),
                order.toString()
        );
        System.out.println("Order successfully saved!");
    }
}
