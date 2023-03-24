package org.example;

import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<String> pokupki = new ArrayList<>();

    private Long catSum;

    public Category(String name, ArrayList<String> pokupki, Long catSum) {
        this.name = name;
        this.pokupki = pokupki;
        this.catSum = catSum;

    }

    public void addPokupka(String pokupka) {
        if (!pokupki.contains(pokupka)
        ) pokupki.add(pokupka);
    }

    public String getName() {
        return name;
    }

    public Long getSum() {
        return catSum;
    }

    public ArrayList<String> getPokupki() {
        return pokupki;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSum(Long sum) {
        catSum = catSum + sum;
    }
}
