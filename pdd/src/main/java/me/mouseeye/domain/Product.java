package me.mouseeye.domain;

public class Product {

    private final String id;

    private final Pdd pdd;

    public Product(String id, Pdd pdd) {
        this.id = id;
        this.pdd = pdd;
    }

    public String getId() {
        return id;
    }

}
