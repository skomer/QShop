package com.elderj.qshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CatalogueAdapter extends ArrayAdapter<Product> implements View.OnClickListener {

    Product product;

    public CatalogueAdapter(Context context, ArrayList<Product> productCatalogue) {
        super(context, 0, productCatalogue);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        product = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.catalogue_list_item, parent, false);
        }

        TextView productName = (TextView) convertView.findViewById(R.id.product_name);
        TextView productSellDiscount = (TextView) convertView.findViewById(R.id.product_discount);
        TextView productQuantity = (TextView) convertView.findViewById(R.id.product_quantity);
        Button orderOneButton = (Button) convertView.findViewById(R.id.order_one_button);
        Button orderTenButton = (Button) convertView.findViewById(R.id.order_ten_button);

        productName.setText(product.name);
        productSellDiscount.setText((product.discount).toString());
        productQuantity.setText("9876");
        orderOneButton.setOnClickListener(this);
        orderTenButton.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View view) {
        Context context = view.getContext();

        switch (view.getId()) {
            case R.id.order_one_button:
                ((MainActivityView) context).orderOneButtonTapped(product);
                break;
            case R.id.order_ten_button:
                ((MainActivityView) context).orderTenButtonTapped(product);
                break;
        }
    }

}
