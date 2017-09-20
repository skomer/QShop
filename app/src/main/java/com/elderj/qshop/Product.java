package com.elderj.qshop;

public class Product {

    public final String name;
    public final double buyPrice;
    public final double sellPrice;
    public Discount discount;

    public Product(String name, double buyPrice, double sellPrice, Discount discount) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.discount = discount;
    }

}
