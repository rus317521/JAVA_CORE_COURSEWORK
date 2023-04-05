package org.example;

import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class CategoriesTest extends TestCase {

    public void testAddCategory() {
        ArrayList<String> pokupki = new ArrayList<>();
        pokupki.add("туфли");
        pokupki.add("ботинки");
        Category category1 = new Category("обувь", pokupki, 10000L);


        ArrayList<String> pokupki2 = new ArrayList<>();
        pokupki2.add("ремень");
        Category category2 = new Category("аксессуары", pokupki2, 0L);

        ArrayList<Category> categoryShoes = new ArrayList<>();
        categoryShoes.add(category1);

        ArrayList<Category> categoryAccessories = new ArrayList<>();
        categoryAccessories.add(category2);

        ArrayList<Category> categoriesShoesAndAccessories = new ArrayList<>();
        categoriesShoesAndAccessories.add(category1);
        categoriesShoesAndAccessories.add(category2);

        Categories categoriesSandA = new Categories(categoriesShoesAndAccessories);

        Categories categoriesSandABeforeAdd = categoriesSandA;
        categoriesSandA.addCategory("обувь", "ботинки");
        Assertions.assertEquals(categoriesSandABeforeAdd, categoriesSandA);
    }

    public void testGetCategoryName() {

        ArrayList<String> pokupki = new ArrayList<>();
        pokupki.add("туфли");
        pokupki.add("ботинки");
        Category category1 = new Category("обувь", pokupki, 10000L);


        ArrayList<String> pokupki2 = new ArrayList<>();
        pokupki2.add("ремень");
        Category category2 = new Category("аксессуары", pokupki2, 0L);

        ArrayList<Category> categoryShoes = new ArrayList<>();
        categoryShoes.add(category1);

        ArrayList<Category> categoryAccessories = new ArrayList<>();
        categoryAccessories.add(category2);

        ArrayList<Category> categoriesShoesAndAccessories = new ArrayList<>();
        categoriesShoesAndAccessories.add(category1);
        categoriesShoesAndAccessories.add(category2);

        Categories categoriesSandA = new Categories(categoriesShoesAndAccessories);

        Assertions.assertEquals("обувь", categoriesSandA.getCategoryName("ботинки"));


    }

    public void testGetCategory() {

        ArrayList<String> pokupki = new ArrayList<>();
        pokupki.add("туфли");
        pokupki.add("ботинки");
        Category category1 = new Category("обувь", pokupki, 10000L);


        ArrayList<String> pokupki2 = new ArrayList<>();
        pokupki2.add("ремень");
        Category category2 = new Category("аксессуары", pokupki2, 0L);

        ArrayList<Category> categoryShoes = new ArrayList<>();
        categoryShoes.add(category1);

        ArrayList<Category> categoryAccessories = new ArrayList<>();
        categoryAccessories.add(category2);

        ArrayList<Category> categoriesShoesAndAccessories = new ArrayList<>();
        categoriesShoesAndAccessories.add(category1);
        categoriesShoesAndAccessories.add(category2);

        Categories categoriesSandA = new Categories(categoriesShoesAndAccessories);

        Category category = categoriesSandA.getCategory("туфли");
        Assertions.assertEquals(category1, category);

    }

    public void testMaxCategory() {

        ArrayList<String> pokupki = new ArrayList<>();
        pokupki.add("туфли");
        pokupki.add("ботинки");
        Category category1 = new Category("обувь", pokupki, 10000L);


        ArrayList<String> pokupki2 = new ArrayList<>();
        pokupki2.add("ремень");
        Category category2 = new Category("аксессуары", pokupki2, 0L);

        ArrayList<String> pokupki3 = new ArrayList<>();
        pokupki3.add("телевизор");
        pokupki3.add("холодильник");
        pokupki3.add("микроволновка");
        Category category3 = new Category("техника", pokupki3, 15000L);

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        Categories categoriesAll = new Categories(categories);

        JSONObject categoryObject = new JSONObject();
        JSONObject maxCategoryObject = new JSONObject();
        JSONArray maxCategory = new JSONArray();
        categoryObject.put("sum", category3.getSum());
        categoryObject.put("category", category3.getName());

        maxCategory.add(categoryObject);
        maxCategoryObject.put("maxCategory", categoryObject);

        Assertions.assertEquals(maxCategoryObject.toString(), categoriesAll.maxCategory());
    }

}