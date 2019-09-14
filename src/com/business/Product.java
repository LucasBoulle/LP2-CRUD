package com.business;

import com.dao.ProductRepository;
import java.io.IOException;

public class Product extends RegistrableObject {
    @Override
    public void register(RegistrableObject obj) throws IOException {
        ProductRepository repository = new ProductRepository();
        repository.registerProduct((Product) obj);
    }

    public Product(String sku, double price, String title) {
        if(sku.isEmpty() || title.isEmpty())
            throw new IllegalArgumentException("Value cannot be empty.");
        this.sku = sku;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return sku + "|" + price + "|" + title;
    }

    private String title;
    private String sku;
    private double price;
}
