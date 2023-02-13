package com.example.bjosefow_21_mvc_thymeleaf;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Product> getProductListWithCategory(String category) {
        return productList
                .stream()
                .filter(product -> product.getProductCategory().getDescription().equals(category))
                .toList();
    }

    public double getSumPriceForProducts(List<Product> productList) {
        return productList
                .stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
    }

}
