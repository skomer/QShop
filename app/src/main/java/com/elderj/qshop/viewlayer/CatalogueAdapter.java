package com.elderj.qshop.viewlayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.elderj.qshop.models.Product;
import com.elderj.qshop.R;

import java.util.ArrayList;

public class CatalogueAdapter extends ArrayAdapter<Product> {

    Product product;
    View.OnClickListener onClickListener;

    public CatalogueAdapter(Context context, ArrayList<Product> productCatalogue, View.OnClickListener onClickListener) {
        super(context, 0, productCatalogue);
        this.onClickListener = onClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        product = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.catalogue_list_item, parent, false);
        }

        TextView productName = (TextView) convertView.findViewById(R.id.product_name);
        TextView productSellDiscount = (TextView) convertView.findViewById(R.id.product_discount);
        TextView productPrice = (TextView) convertView.findViewById(R.id.product_price);
        Button orderOneButton = (Button) convertView.findViewById(R.id.order_one_button);
        Button orderTenButton = (Button) convertView.findViewById(R.id.order_ten_button);

        productName.setText(product.name);
        productSellDiscount.setText((product.discount).toString());
        productPrice.setText(Double.toString(product.buyPrice));
        orderOneButton.setOnClickListener(onClickListener);
        orderTenButton.setOnClickListener(onClickListener);

        return convertView;
    }

}
