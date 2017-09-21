package com.elderj.qshop.viewlayer;


import com.elderj.qshop.models.Product;
import com.elderj.qshop.models.Shop;

import java.util.ArrayList;

public interface MainActivityView {

    void showShopBalance(String shopBalance);
    void showShopStock(Shop shop);
    void displayMessage(String message);
    void showCatalogueItems(ArrayList<Product> productCatalogue);

}

