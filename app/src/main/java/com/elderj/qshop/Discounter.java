package com.elderj.qshop;

public class Discounter implements Discounting {

    public Discounter() {}

    public double getBuyCost(Product product, int quantity) {
        double discountAmount;
        double priceBeforeDiscount = product.buyPrice * quantity;

        switch (product.discount) {
            case NONE:
                return priceBeforeDiscount;

            case BOGOF:
                if (quantity % 2 == 0) {
                    return ((product.buyPrice * quantity) / 2);
                } else {
                    int discountQuantity = (quantity - 1) / 2;
                    discountAmount = discountQuantity * product.buyPrice;

                    return priceBeforeDiscount - discountAmount;
                }

            case THREEFORTWO:
                int discountQuantity;
                if  (quantity % 3 == 0) {
                    discountQuantity = quantity / 3;
                } else if ((quantity - 1) % 3 == 0) {
                    discountQuantity = (quantity - 1) / 3;
                } else {
                    discountQuantity = (quantity - 2) / 3;
                }
                discountAmount = product.buyPrice * discountQuantity;

                return priceBeforeDiscount - discountAmount;

            case BUYTENSAVETENPERCENT:
                if (quantity % 10 == 0) {
                    return priceBeforeDiscount * 0.9;
                } else {
                    Double nearestLowerTen = Math.round((quantity - 5)/ 10.0) * 10.0;
                    int intNearestLowerTen = nearestLowerTen.intValue();

                    int unDiscountedQuantity = quantity - intNearestLowerTen;
                    discountAmount = intNearestLowerTen * product.buyPrice * 0.9;
                    double unDiscountedAmount = unDiscountedQuantity * product.buyPrice;

                    return discountAmount + unDiscountedAmount;
                }
        }

        return priceBeforeDiscount;
    }

}
