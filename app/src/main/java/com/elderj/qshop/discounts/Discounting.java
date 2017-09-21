package com.elderj.qshop.discounts;

import com.elderj.qshop.models.Product;

public interface Discounting {

    double getBuyCost(Product product, int quantity);

}
