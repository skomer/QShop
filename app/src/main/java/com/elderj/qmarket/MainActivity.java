package com.elderj.qmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}

// load some existing products and a supermarket balance
// have a 'new supermarket' template
// read from db
// first of all get it to load up some products
// show both supermarket stock and customer basket