package com.dao;

import com.business.Customer;
import com.business.Product;
import com.commons.enums.EnumDataRepositoryPath;

import java.io.IOException;
import java.util.Arrays;

public class CustomerRepository {
    public void registerCustomer(Customer customer) throws IOException {
        RepositoryActions actions = new RepositoryActions();
        actions.writeFile(
                EnumDataRepositoryPath.Customer.getPath(),
                customer.toString()
        );
        System.out.println("Customer successfully saved!");
    }

    public boolean customerIsAlreadyRegistered(String customer) throws IOException {
        RepositoryActions actions = new RepositoryActions();
        String[] customers = collectCustomerArr(
                actions.readLines(EnumDataRepositoryPath.Customer.getPath())
        );

        return Arrays.stream(customers).anyMatch(customer::equals);
    }

    private String[] collectCustomerArr(String[] products) {
        int i = 0;
        for (String product : products) {
            products[i] = product.split("\\|")[0];
            i++;
        }
        return products;
    }
}
