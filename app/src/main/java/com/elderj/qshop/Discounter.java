package com.elderj.qshop;

public class Discounter implements Discounting {

    public Discounter() {}



    public double getBuyCost(Product product, int quantity) {
        switch (product.discount) {
            case NONE:

                break;
            case BOGOF:
                double priceBeforeDiscount = product.buyPrice * quantity;
                if (quantity % 2 == 0) {
                    return ((product.buyPrice * quantity) / 2);
                } else {
                    int discountQuantity = (quantity - 1) / 2;
                    double discountAmount = discountQuantity * product.buyPrice;

                    return priceBeforeDiscount - discountAmount;
                }


        }


        return 0.0;
    }

}
