package com.elderj.qmarket;

import java.util.ArrayList;

public class Presenter {

    MainActivityView view;

    public Presenter(MainActivityView view) {
        this.view = view;
    }

    public void onResume() {
        view.showBaseProducts(new ArrayList<String>());
    }


}
