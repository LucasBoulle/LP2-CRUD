package com.commons;

public enum EnumDataRepositoryPath {
    Product("src/com/data/products.txt"),
    Order("src/com/data/orders.txt"),
    Employee("src/com/data/employees.txt"),
    ;

    private final String path;
    EnumDataRepositoryPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
