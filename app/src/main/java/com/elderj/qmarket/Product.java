package com.elderj.qmarket;

public class Product {

    public final String name;
    public final long buyPrice;
    public final long sellPrice;

    public Product(String name, long buyPrice, long sellPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

}
