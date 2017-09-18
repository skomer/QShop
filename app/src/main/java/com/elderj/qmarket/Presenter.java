package com.elderj.qmarket;

public class Presenter {

    MainActivityView view;

    public Presenter(MainActivityView view) {
        this.view = view;
    }

    public void onResume() {
        view.showBaseProducts();
    }


}
