package me.mouseeye.domain;

public class Product {

    private final Integer id;
    private final String title;
    private final Integer stockQuantity;

    public Product(Integer id, String title, Integer stockQuantity) {
        this.id = id;
        this.title = title;
        this.stockQuantity = stockQuantity;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }
}
