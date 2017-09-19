package com.elderj.qmarket;

import java.util.ArrayList;
import java.util.List;

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

        view.showBaseProducts(productNames);
        view.showBaseShop(shop);
    }

    public void buyStock(String productName, int quantity) {
        double buyPrice = getBuyPrice(productName);
        double buyCost = buyPrice * quantity;
        double balance = shop.getBalance();
        double newBalance = balance - buyCost;

        if (newBalance > 0) {
            String stock = shop.getStock();
            shop.setStock(stock + "+" + String.valueOf(quantity));
            shop.setBalance(newBalance);
        }
    }

    private double getBuyPrice(String productName) {
        double buyPrice = 0;

        for (Product product : baseProducts) {
            if (product.name.equals(productName)) {
                buyPrice = product.buyPrice;
                break;
            }
        }

        return buyPrice;
    }


}
