package com.elderj.qshop;

import java.util.Map;

public class Shop {

    private Map<Product, Integer> stock;
    private double balance;

    public Shop(Map<Product, Integer> stock, double balance) {
        this.stock = stock;
        this.balance = balance;
    }

    public Map<Product, Integer> getStock() {
        return stock;
    }

    public void setStock(Product product, int newQuantity) {
        stock.put(product, newQuantity);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
}
