package com.elderj.qshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    Presenter presenter;
    TextView baseProducts;
    TextView stock;
    TextView balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseProducts = (TextView) findViewById(R.id.base_products);
        stock = (TextView) findViewById(R.id.shop_stock);
        balance = (TextView) findViewById(R.id.shop_balance);

        Map<String, Integer> stock = new HashMap();
        stock.put("egg", 100);
        stock.put("apple", 100);

        presenter = new Presenter(this, new Shop(stock, 1000.0));
    }

    @Override
    protected void onResume() {
        presenter.onResume();
    }

    public void showShopStock(Shop shop) {
        stock.setText("STOCK");
    }

    public void showShopBalance(String shopBalance) {
        balance.setText(shopBalance);
    }

}
