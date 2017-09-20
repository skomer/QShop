package com.elderj.qshop;


public interface MainActivityView {

    void showShopBalance(String shopBalance);
    void showShopStock(Shop shop);
    void orderStockButtonTapped(Product product);
    void displayMessage(String message);

}

