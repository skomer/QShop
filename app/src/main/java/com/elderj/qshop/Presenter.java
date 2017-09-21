package com.elderj.qshop;

import com.elderj.qshop.discounts.Discount;
import com.elderj.qshop.discounts.Discounting;
import com.elderj.qshop.models.Product;
import com.elderj.qshop.models.Shop;
import com.elderj.qshop.viewlayer.MainActivityView;

import java.util.ArrayList;
import java.util.Map;

public class Presenter {

    private MainActivityView view;
    private Shop shop;
    private ArrayList<Product> productCatalogue;
    private Discounting discounter;

    public Presenter(MainActivityView view, Shop shop, Discounting discounter) {
        this.view = view;
        this.shop = shop;
        this.discounter = discounter;
    }

    public void onResume() {
        view.showShopBalance(Double.toString(shop.getBalance()));
        view.showShopStock(shop);

        productCatalogue = new ArrayList<>();
        productCatalogue.add(new Product("egg", 1.0, 2.0, Discount.NONE));
        productCatalogue.add(new Product("apple", 0.5, 1.1, Discount.NONE));
        productCatalogue.add(new Product("pineapple", 3.0, 5.5, Discount.THREEFORTWO));
        productCatalogue.add(new Product("rice", 1.5, 3.0, Discount.NONE));
        productCatalogue.add(new Product("juice", 0.7, 3.0, Discount.BUYTENSAVETENPERCENT));

        view.showCatalogueItems(productCatalogue);
    }

    public void buyStock(Product product, int quantity) {
        boolean isInCatalogue = checkCatalogue(product);

        if (!isInCatalogue) {
            view.displayMessage("Product not ordered.\nNot available to order.");
        } else {
            double buyCost = discounter.getBuyCost(product, quantity);
            double balance = shop.getBalance();

            double newBalance = balance - buyCost;

            if (newBalance > 0) {
                double discountSaving = (product.buyPrice * quantity) - buyCost;
                String stringSaving = String.format("%.2f", discountSaving);

                shop.setStock(product.name, quantity);

                shop.setBalance(newBalance);
                view.showShopStock(shop);
                String stringBalance = String.format("%.2f", newBalance);
                view.showShopBalance(stringBalance);
                view.displayMessage("Product ordered.\nStock and balance updated.\nYou saved " + stringSaving + " in discounts!");
            } else {
                view.displayMessage("Product not ordered.\nBalance too low.");
            }
        }
    }

    private boolean checkCatalogue(Product product) {
        return productCatalogue.contains(product);
    }

    public void sellStock(Product product, int sellQuantity) {
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

    public void orderOneButtonTapped(int position) {
        Product selectedProduct = productCatalogue.get(position);
        buyStock(selectedProduct, 1);
    }

    public void orderTenButtonTapped(int position) {
        Product selectedProduct = productCatalogue.get(position);
        buyStock(selectedProduct, 10);
    }

}
