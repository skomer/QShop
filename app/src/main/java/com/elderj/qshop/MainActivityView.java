package com.elderj.qshop;


public interface MainActivityView {

    void showShopBalance(String shopBalance);
    void showShopStock(Shop shop);
    void orderOneButtonTapped(Product product);
    void orderTenButtonTapped(Product product);
    void displayMessage(String message);

}

