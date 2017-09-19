package com.elderj.qmarket;

public class Product {

    public final String name;
    public final double buyPrice;
    public final double sellPrice;

    public Product(String name, double buyPrice, double sellPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

}
