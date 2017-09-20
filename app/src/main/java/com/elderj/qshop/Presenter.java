package com.elderj.qshop;

import java.util.ArrayList;
import java.util.Map;

public class Presenter {

    MainActivityView view;
    Shop shop;
    ArrayList<Product> productCatalogue;
    Discounting discounter;

    public Presenter(MainActivityView view, Shop shop, ArrayList<Product> productCatalogue, Discounting discounter) {
        this.view = view;
        this.shop = shop;
        this.productCatalogue = productCatalogue;
        this.discounter = discounter;
    }

    public void onResume() {
        view.showShopBalance(Double.toString(shop.getBalance()));
        view.showShopStock(shop);
    }

    public void buyStock(String productName, int quantity) {
        Product product = getProduct(productName);

        double buyCost = discounter.getBuyCost(product, quantity);
        double balance = shop.getBalance();
        double newBalance = Math.round(balance - buyCost);

        if (newBalance > 0) {
            double discountSaving = Math.round((product.buyPrice * quantity) - buyCost);
            shop.setStock(product.name, quantity);
            shop.setBalance(newBalance);
            view.showShopStock(shop);
            view.showShopBalance(Double.toString(newBalance));
            view.displayMessage("Product ordered.\nStock and balance updated.\nYou saved " + discountSaving + " in discounts!");
        } else {
            view.displayMessage("Product not ordered.\nBalance too low.");
        }
    }

    private Product getProduct(String productName) {
        for (Product product : productCatalogue) {
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
            view.displayMessage("Product sold.\nStock and balance updated.");
        } else {
            view.displayMessage("Product not sold.\nInsufficient stock.");
        }
    }

    public void orderOneButtonTapped(Product product) {
        buyStock(product.name, 1);
    }

    public void orderTenButtonTapped(Product product) {
        buyStock(product.name, 10);
    }

}
