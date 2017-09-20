package com.elderj.qshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StockAdapter extends ArrayAdapter<Product> {

    public StockAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.stock_list_item, parent, false);
        }

        TextView productName = (TextView) convertView.findViewById(R.id.product_name);
        TextView productSellDiscount = (TextView) convertView.findViewById(R.id.product_sell_discount);
        TextView productQuantity = (TextView) convertView.findViewById(R.id.product_quantity);

        productName.setText(product.name);
        productSellDiscount.setText((product.discount).toString());
        productQuantity.setText("9876");

        return convertView;
    }
    
}
