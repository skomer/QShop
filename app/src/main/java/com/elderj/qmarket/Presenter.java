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
        List<String> baseProducts = new ArrayList<>();
        baseProducts.add("potatoes");
        baseProducts.add("peas");
        baseProducts.add("lemonade");
        baseProducts.add("eggs");

        view.showBaseProducts(baseProducts);
        view.showBaseShop(new Shop("potatoes, eggs, peas", 1000.00));
    }

    public void buyStock(String productName, int quantity) {


    }


}
