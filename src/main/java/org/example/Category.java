package org.example;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<String> products = new ArrayList<>();

    private Long catSum;

    public Category(String name, List<String> products, Long catSum) {
        this.name = name;
        this.products = products;
        this.catSum = catSum;

    }

    public void addProduct(String product) {
        if (!products.contains(product)
        ) products.add(product);
    }

    public String getName() {
        return name;
    }

    public Long getSum() {
        return catSum;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSum(Long sum) {
        catSum = catSum + sum;
    }
}
