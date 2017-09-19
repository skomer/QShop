package com.elderj.qmarket;

import java.util.ArrayList;
import java.util.List;

public class Presenter {

    MainActivityView view;

    public Presenter(MainActivityView view) {
        this.view = view;
    }

    public void onResume() {
        List<String> baseProducts = new ArrayList<>();
        baseProducts.add("potatoes");
        baseProducts.add("peas");
        baseProducts.add("lemonade");
        baseProducts.add("eggs");

        view.showBaseProducts(baseProducts);
        view.showBaseSupermarket(new Supermarket("potatoes, eggs, peas", 1000.00));
    }

}
