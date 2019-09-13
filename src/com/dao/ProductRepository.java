package com.dao;

import com.business.Product;
import com.commons.enums.EnumDataRepositoryPath;

import java.io.IOException;
import java.util.Arrays;

public class ProductRepository {
    public void registerProduct(Product product) throws IOException {
        RepositoryActions actions = new RepositoryActions();
        actions.writeFile(
                EnumDataRepositoryPath.Product.getPath(),
                product.toString()
        );
        System.out.println("Product successfully saved!");
    }

    public boolean skuIsAlreadyRegistered(String sku) throws IOException {
        RepositoryActions actions = new RepositoryActions();
        String[] skus = collectSkuArr(
                actions.readLines(EnumDataRepositoryPath.Product.getPath())
        );

        return Arrays.stream(skus).anyMatch(sku::equals);
    }

    private String[] collectSkuArr(String[] products) {
        int i = 0;
        for (String product : products) {
            products[i] = product.split("\\|")[0];
            i++;
        }
        return products;
    }
}
