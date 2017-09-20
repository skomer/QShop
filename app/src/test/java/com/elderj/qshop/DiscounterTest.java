package com.elderj.qshop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class DiscounterTest {

    private Discounting discounter;

    @Test
    public void discounter_applies_no_buying_discount_when_none_specified() {
        discounter = new Discounter();
        Product product = new Product("", 1.0, 2.0, Discount.NONE);

        double actualBuyCost = discounter.getBuyCost(product, 2);

        assertThat(2.0, is(equalTo(actualBuyCost)));
    }

    @Test
    public void discounter_applies_buying_bogof_discount_when_quantity_is_even() {
        discounter = new Discounter();
        Product product = new Product("", 1.0, 2.0, Discount.BOGOF);

        double actualBuyCost = discounter.getBuyCost(product, 2);

        assertThat(1.0, is(equalTo(actualBuyCost)));
    }

    @Test
    public void discounter_applies_buying_bogof_when_quantity_is_odd() {
        discounter = new Discounter();
        Product product = new Product("", 1.0, 2.0, Discount.BOGOF);

        double actualBuyCost = discounter.getBuyCost(product, 7);

        assertThat(4.0, is(equalTo(actualBuyCost)));
    }

    @Test
    public void discounter_applies_buying_three_for_two_discount() {
        discounter = new Discounter();
        Product product = new Product("", 1.0, 2.0, Discount.THREEFORTWO);

        double actualBuyCost = discounter.getBuyCost(product, 7);

        assertThat(5.0, is(equalTo(actualBuyCost)));
    }

    @Test
    public void discounter_applies_ten_percent_discount_when_quantity_is_multiple_of_ten() {
        discounter = new Discounter();
        Product product = new Product("", 1.0, 2.0, Discount.BUYTENSAVETENPERCENT);

        double actualBuyCost = discounter.getBuyCost(product, 100);

        assertThat(90.0, is(equalTo(actualBuyCost)));
    }

}