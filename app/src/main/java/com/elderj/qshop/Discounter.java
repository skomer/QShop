package com.elderj.qshop;

public class Discounter implements Discounting {

    public Discounter() {}



    public double getBuyCost(Product product, int quantity) {
        switch (product.discount) {
            case NONE:

                break;
            case BOGOF:
                if (quantity % 2 == 0) {
                    return ((product.buyPrice * quantity) / 2);
                }


                break;



        }


        return 0.0;
    }

}
