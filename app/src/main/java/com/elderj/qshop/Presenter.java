package com.elderj.qshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Presenter {

    MainActivityView view;
    Shop shop;
    List<Product> baseProducts;

    public Presenter(MainActivityView view, Shop shop) {
        this.view = view;
        this.shop = shop;
    }

    public void onResume() {
        baseProducts = new ArrayList<>();
        baseProducts.add(new Product("potatoes", 1.0, 2.0));
        baseProducts.add(new Product("peas", 0.05, 0.10));
        baseProducts.add(new Product("lemonade", 2.0, 4.0));
        baseProducts.add(new Product("eggs", 0.5, 1.0));

        List<String> productNames = new ArrayList<>();
        for (Product product : baseProducts) {
            productNames.add(product.name);
        }

        view.showShopBalance(Double.toString(shop.getBalance()));
        view.showShopStock(shop);
    }

    public void buyStock(String productName, int quantity) {
        Product product = getProduct(productName);
        double buyCost = product.buyPrice * quantity;
        double balance = shop.getBalance();
        double newBalance = balance - buyCost;

        if (newBalance > 0) {
            shop.setStock(product, quantity);
            shop.setBalance(newBalance);
        }
    }

    private Product getProduct(String productName) {
        for (Product product : baseProducts) {
            if (product.name.equals(productName)) {
                return product;
            }
        }

        return new Product("", 0.0, 0.0);
    }


}