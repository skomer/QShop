package com.elderj.qshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    Presenter presenter;
    private TextView stock;
    private TextView balance;
    private TextView expandable;
    private TextView hideShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stock = (TextView) findViewById(R.id.shop_stock);
        balance = (TextView) findViewById(R.id.shop_balance);
        expandable = (TextView) findViewById(R.id.expandable);
        hideShow = (TextView) findViewById(R.id.hide_show);
        hideShow.setVisibility(View.GONE);

        List<String> productNames = new ArrayList<>();
        productNames.add("egg");
        productNames.add("pineapple");
        productNames.add("rice");
        productNames.add("soap");

        Map<String, Integer> stock = new HashMap();
        stock.put("egg", 100);
        stock.put("apple", 100);

        presenter = new Presenter(this, new Shop(stock, 1000.0));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    public void toggle_contents(View v){
        hideShow.setVisibility( hideShow.isShown()
                ? View.GONE
                : View.VISIBLE );
    }


    public void showShopStock(Shop shop) {
        stock.setText("STOCK");
    }

    public void showShopBalance(String shopBalance) {
        balance.setText(shopBalance);
    }

}
