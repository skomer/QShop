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
        baseProducts.add(new Product("potatoes", 1.0, 2.0, Discount.NONE));
        baseProducts.add(new Product("peas", 0.05, 0.10, Discount.NONE));
        baseProducts.add(new Product("lemonade", 2.0, 4.0, Discount.NONE));
        baseProducts.add(new Product("egg", 0.5, 1.0, Discount.NONE));

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
            shop.setStock(product.name, quantity);
            shop.setBalance(newBalance);
            view.showShopStock(shop);
            view.showShopBalance(Double.toString(newBalance));
        }
    }

    private Product getProduct(String productName) {
        for (Product product : baseProducts) {
            if (product.name.equals(productName)) {
                return product;
            }
        }

        return new Product("", 0.0, 0.0, Discount.NONE);
    }

    public void sellStock(String productName, int sellQuantity) {
        Product product = getProduct(productName);

        double sellPrice = product.sellPrice * sellQuantity;
        double newBalance = shop.getBalance() + sellPrice;

        // Refactor. Can't stub shop.getStock().get(product.name) => code smell?
        Map<String, Integer> stock = shop.getStock();
        int newStockQuantity = stock.get(product.name) - sellQuantity;

        if (newStockQuantity > -1) {
            shop.setBalance(newBalance);
            shop.setStock(product.name, newStockQuantity);
            view.showShopStock(shop);
            view.showShopBalance(Double.toString(newBalance));
        }
    }

    public void orderOneButtonTapped(Product product) {
        buyStock(product.name, 1);

        view.displayMessage("Product ordered: " + product.name);
    }

    public void orderTenButtonTapped(Product product) {
        buyStock(product.name, 10);

        view.displayMessage("Product ordered: " + product.name);
    }

}
