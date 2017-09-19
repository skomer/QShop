package com.elderj.qshop;

import java.util.Map;

public class Shop {

    private Map<String, Integer> stock;
    private double balance;

    public Shop(Map<String, Integer> stock, double balance) {
        this.stock = stock;
        this.balance = balance;
    }

    public Map<String, Integer> getStock() {
        return stock;
    }

    public void setStock(String productName, int newQuantity) {
        stock.put(productName, newQuantity);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
}
