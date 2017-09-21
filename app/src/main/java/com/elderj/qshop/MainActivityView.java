package com.elderj.qshop;


import java.util.ArrayList;

public interface MainActivityView {

    void showShopBalance(String shopBalance);
    void showShopStock(Shop shop);
    void displayMessage(String message);
    void showCatalogueItems(ArrayList<Product> productCatalogue);

}

