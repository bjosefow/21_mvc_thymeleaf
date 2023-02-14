package com.example.bjosefow_21_mvc_thymeleaf;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        productList.add(new Product("czekolada", 5.5, Category.GROCERIES));
        productList.add(new Product("poduszka", 20.0, Category.HOUSEHOLD_ART));
        productList.add(new Product("mleko", 2.3, Category.GROCERIES));
        productList.add(new Product("baterie", 15.0, Category.OTHER));
        productList.add(new Product("karma", 22.0, Category.OTHER));
        productList.add(new Product("opony", 120.0, Category.OTHER));
        productList.add(new Product("farba", 45.0, Category.OTHER));
        productList.add(new Product("garnki", 45.5, Category.HOUSEHOLD_ART));
        productList.add(new Product("patelnie", 60.0, Category.HOUSEHOLD_ART));
    }

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
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
