package com.elderj.qshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    Presenter presenter;
    private TextView balance;
    private TextView expandable;
    private ListView stockListView;
    private TextView hideShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        balance = (TextView) findViewById(R.id.shop_balance);
        expandable = (TextView) findViewById(R.id.expandable);
        stockListView = (ListView) findViewById(R.id.stock_listview);

        hideShow = (TextView) findViewById(R.id.hide_show);
        hideShow.setVisibility(View.GONE);

        ArrayList<Product> productCatalogue = new ArrayList<>();
        productCatalogue.add(new Product("egg", 1.0, 2.0, Discount.NONE));
        productCatalogue.add(new Product("apple", 0.5, 1.1, Discount.NONE));
        productCatalogue.add(new Product("pineapple", 3.0, 5.5, Discount.THREEFORTWO));
        productCatalogue.add(new Product("rice", 1.5, 3.0, Discount.NONE));
        productCatalogue.add(new Product("juice", 0.7, 3.0, Discount.BUYTENSAVETENPERCENT));

        StockAdapter adapter = new StockAdapter(this, productCatalogue);
        stockListView.setAdapter(adapter);

        Map<String, Integer> stock = new HashMap();
        stock.put("egg", 100);
        stock.put("apple", 100);

        presenter = new Presenter(this, new Shop(stock, 1000.0), productCatalogue, new Discounter());
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
        // give view arraylist of products, on which to set the adapter
    }

    public void showShopBalance(String shopBalance) {
        balance.setText(shopBalance);
    }

    public void orderOneButtonTapped(Product product) {
        presenter.orderOneButtonTapped(product);
    }

    public void orderTenButtonTapped(Product product) {
        presenter.orderTenButtonTapped(product);
    }

    public void displayMessage(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }

}
