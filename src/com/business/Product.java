package com.business;

import com.dao.ProductRepository;

import java.io.FileWriter;
import java.io.IOException;

public class Product extends RegistrableObject {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public void register(RegistrableObject obj) throws IOException {
        ProductRepository repository = new ProductRepository();
        repository.registerProduct((Product) obj);
    }

    public Product(String sku, double price, String title) {
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
