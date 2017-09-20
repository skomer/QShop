package com.elderj.qshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StockAdapter extends ArrayAdapter<Product> implements View.OnClickListener {

    Product product;

    public StockAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        product = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.stock_list_item, parent, false);
        }

        TextView productName = (TextView) convertView.findViewById(R.id.product_name);
        TextView productSellDiscount = (TextView) convertView.findViewById(R.id.product_sell_discount);
        TextView productQuantity = (TextView) convertView.findViewById(R.id.product_quantity);
        Button orderButton = (Button) convertView.findViewById(R.id.order_button);

        productName.setText(product.name);
        productSellDiscount.setText((product.discount).toString());
        productQuantity.setText("9876");
        orderButton.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        ((MainActivityView) context).orderStockButtonTapped(product);
    }

}
