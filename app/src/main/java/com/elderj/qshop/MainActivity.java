package com.elderj.qshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainActivityView, View.OnClickListener {

    Presenter presenter;
    private TextView balance;
    private TextView expandable;
    private ListView catalogueListView;
    private TextView hideShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        balance = (TextView) findViewById(R.id.shop_balance);
        expandable = (TextView) findViewById(R.id.expandable);
        catalogueListView = (ListView) findViewById(R.id.catalogue_listview);

        hideShow = (TextView) findViewById(R.id.hide_show);
        hideShow.setVisibility(View.GONE);

        Map<String, Integer> stock = new HashMap();
        stock.put("egg", 100);
        stock.put("apple", 100);

        presenter = new Presenter(this, new Shop(stock, 1000.0), new Discounter());
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

    public void showShopBalance(final String shopBalance) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                balance.setText(shopBalance);
            }
        });
    }

    public void showCatalogueItems(ArrayList<Product> productCatalogue) {
        CatalogueAdapter adapter = new CatalogueAdapter(this, productCatalogue, this);
        catalogueListView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_one_button:
                final int positionOne = catalogueListView.getPositionForView((LinearLayout)view.getParent());
                presenter.orderOneButtonTapped(positionOne);
                break;
            case R.id.order_ten_button:
                final int positionTen = catalogueListView.getPositionForView((LinearLayout)view.getParent());
                presenter.orderTenButtonTapped(positionTen);
                break;
        }
    }

    public void displayMessage(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
