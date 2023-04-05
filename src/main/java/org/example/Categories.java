package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categories implements Serializable {
    private List<Category> categories;

    public Categories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(String name, String product) {
        boolean flag = true;
        if ((this.categories != null)) {
            for (Category category : categories) {
                if (category.getName().equals(name)) {
                    category.addProduct(product);
                    flag = false;
                }

            }
            if (flag) //Надо добавить новую категорию
            {
                List<String> products = new ArrayList<>();
                products.add(product);
                Category category = new Category(name, products, 0L);
                categories.add(category);
            }
        } else {
            List<String> products = new ArrayList<>();
            products.add(product);
            Category category = new Category(name, products, 0L);
            categories.add(category);
        }
    }

    public String getCategoryName(String product) {
        String catName = "другое";
        for (Category category : categories
        ) {
            if (category.getProducts().contains(product)) {
                catName = category.getName();
                break;
            }
        }
        return catName;
    }

    public Category getCategory(String product) {
        String catName = "другое";
        Category categoryNew = null;
        for (Category category : categories
        ) {
            if (category.getName().equals("другое")) {
                categoryNew = category;
                break;
            }
        }

        for (Category category : categories
        ) {
            if (category.getProducts().contains(product)) {
                categoryNew = category;
                break;
            }
        }
        return categoryNew;
    }

    public String maxCategory() {
        Long maxSum = 0L;
        String maxcategory = " ";
        for (Category category : categories
        ) {
            if (category.getSum() > maxSum) {
                maxSum = category.getSum();
                maxcategory = category.getName();
            }

        }

        JSONObject categoryObject = new JSONObject();
        JSONObject maxCategoryObject = new JSONObject();
        JSONArray maxCategory = new JSONArray();
        categoryObject.put("sum", maxSum);
        categoryObject.put("category", maxcategory);

        maxCategory.add(categoryObject);
        maxCategoryObject.put("maxCategory", categoryObject);

        return maxCategoryObject.toString();

    }

    public void addCategory(Category category) {
        categories.add(category);
    }
}
