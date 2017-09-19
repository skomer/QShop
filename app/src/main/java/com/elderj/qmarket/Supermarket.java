package com.elderj.qmarket;

public class Supermarket {

    private String stock;
    private double balance;

    public Supermarket(String stock, double balance) {
        this.stock = stock;
        this.balance = balance;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
