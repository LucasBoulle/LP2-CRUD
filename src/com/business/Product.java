package com.business;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void register(RegistrableObject obj) {
        try (FileWriter file = new FileWriter("/src/data/products.txt")) {
            file.write(sku + "," + title + "," + price);
            System.out.println("Successfully Copied JSON product to File...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int toJSONString() {
        return 0;
    }

    private String title;
    private String sku;
    private int price;
}
