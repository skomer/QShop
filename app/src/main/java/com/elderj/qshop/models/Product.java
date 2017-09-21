package com.elderj.qshop.models;

import com.elderj.qshop.discounts.Discount;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.buyPrice, buyPrice) != 0) return false;
        if (Double.compare(product.sellPrice, sellPrice) != 0) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return discount == product.discount;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(buyPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sellPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }
}
