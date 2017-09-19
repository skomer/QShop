package com.elderj.qmarket;

public class Supermarket {

    private String stock;
    private long balance;

    public Supermarket(String stock, long balance) {
        this.stock = stock;
        this.balance = balance;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
