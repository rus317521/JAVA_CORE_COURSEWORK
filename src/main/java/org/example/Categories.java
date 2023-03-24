package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Categories implements Serializable {
    private ArrayList<Category> categories;

    public Categories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(String name, String pokupka) {
        boolean flag = true;
        if ((this.categories != null)) {
            for (Category category : categories) {
                if (category.getName().equals(name)) {
                    category.addPokupka(pokupka);
                    flag = false;
                }

            }
            if (flag) //Надо добавить новую категорию
            {
                ArrayList<String> pokupki = new ArrayList<>();
                pokupki.add(pokupka);
                Category category = new Category(name, pokupki, 0L);
                categories.add(category);
            }
        } else {
            ArrayList<String> pokupki = new ArrayList<>();
            pokupki.add(pokupka);
            Category category = new Category(name, pokupki, 0L);
            categories.add(category);
        }
    }

    public String getCategoryName(String pokupka) {
        String catName = "другое";
        for (Category category : categories
        ) {
            if (category.getPokupki().contains(pokupka))
                catName = category.getName();
            break;
        }
        return catName;
    }

    public Category getCategory(String pokupka) {
        String catName = "другое";
        Category categoryN = null;
        for (Category category : categories
        ) {
            if (category.getName() == "другое") {
                categoryN = category;
                break;
            }
        }

        for (Category category : categories
        ) {
            if (category.getPokupki().contains(pokupka)) {
                categoryN = category;
                break;
            }
        }
        return categoryN;
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
        return "{ \"maxCategory\": {" + " \"category\": \"" + maxcategory + "\"," + "\"sum\":" + maxSum + "} }";
    }

    public void addCategory(Category category) {
        categories.add(category);
    }
}
