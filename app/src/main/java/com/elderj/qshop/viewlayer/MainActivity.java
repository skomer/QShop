package com.elderj.qshop.viewlayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.elderj.qshop.Presenter;
import com.elderj.qshop.models.Product;
import com.elderj.qshop.R;
import com.elderj.qshop.models.Shop;
import com.elderj.qshop.discounts.Discounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainActivityView, View.OnClickListener {

    Presenter presenter;
    private TextView shopBalance;
    private TextView expandable;
    private RelativeLayout catalogueLayout;
    private ListView catalogueListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shopBalance = (TextView) findViewById(R.id.shop_balance);
        expandable = (TextView) findViewById(R.id.expandable);
        catalogueLayout = (RelativeLayout) findViewById(R.id.catalogue_layout);
        catalogueLayout.setVisibility(View.GONE);

        catalogueListView = (ListView) findViewById(R.id.catalogue_listview);

        Map<String, Integer> stock = new HashMap();
        stock.put("Egg", 100);
        stock.put("Apple", 100);

        presenter = new Presenter(this, new Shop(stock, 1000.0), new Discounter());
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    public void toggle_contents(View v){
        catalogueLayout.setVisibility( catalogueLayout.isShown()
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
                MainActivity.this.shopBalance.setText(shopBalance);
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
