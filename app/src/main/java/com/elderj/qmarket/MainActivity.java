package com.elderj.qmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    Presenter presenter;
    TextView placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeholder = (TextView) findViewById(R.id.placeholder);

        presenter = new Presenter(this);
    }

    @Override
    protected void onResume() {
        presenter.onResume();
    }

    public void showBaseProducts(List<String> productNames) {
        placeholder.setText("list of products");
    }

    public void showBaseSupermarket() {

    }


}

// load some existing products and a supermarket balance
// have a 'new supermarket' template
// read from db
// first of all get it to load up some products
// show both supermarket stock and customer basket