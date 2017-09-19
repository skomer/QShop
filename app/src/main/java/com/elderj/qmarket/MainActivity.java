package com.elderj.qmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

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
        stock = (TextView) findViewById(R.id.supermarket_stock);
        balance = (TextView) findViewById(R.id.supermarket_balance);

        presenter = new Presenter(this);
    }

    @Override
    protected void onResume() {
        presenter.onResume();
    }

    public void showBaseProducts(List<String> productNames) {
        baseProducts.setText("list of products");
    }

    public void showBaseSupermarket(Supermarket baseMarket) {
        stock.setText(baseMarket.getStock());
        balance.setText(Double.toString(baseMarket.getBalance()));
    }

}
