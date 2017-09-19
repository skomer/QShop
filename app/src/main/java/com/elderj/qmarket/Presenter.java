package com.elderj.qmarket;

import java.util.ArrayList;
import java.util.List;

public class Presenter {

    MainActivityView view;
    Shop shop;

    public Presenter(MainActivityView view, Shop shop) {
        this.view = view;
        this.shop = shop;
    }

    public void onResume() {
        List<Product> baseProducts = new ArrayList<>();
        baseProducts.add(new Product("potatoes", 1.0, 2.0));
        baseProducts.add(new Product("peas", 0.05, 0.10));
        baseProducts.add(new Product("lemonade", 2.0, 4.0));
        baseProducts.add(new Product("eggs", 0.5, 1.0));

        List<String> productNames = new ArrayList<>();
        for (Product product : baseProducts) {
            productNames.add(product.name);
        }

        view.showBaseProducts(productNames);
        view.showBaseShop(new Shop("potatoes, eggs, peas", 1000.0));
    }

    public void buyStock(String productName, int quantity) {


    }


}
