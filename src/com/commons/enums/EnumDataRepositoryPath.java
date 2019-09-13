package com.commons.enums;

import java.io.File;

public enum EnumDataRepositoryPath {
    Product("src/com/data/products.txt"),
    Order("src/com/data/orders.txt"),
    Employee("src/com/data/employees.txt"),
    Customer("src/com/data/customers.txt"),
    Log("src/com/data/log.txt"),
    ;

    private final String path;
    EnumDataRepositoryPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return new File(path).getAbsolutePath();
    }
}
