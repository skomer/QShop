package com.elderj.qshop;

import com.elderj.qshop.discounts.Discount;
import com.elderj.qshop.discounts.Discounting;
import com.elderj.qshop.models.Product;
import com.elderj.qshop.models.Shop;
import com.elderj.qshop.viewlayer.MainActivityView;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PresenterTest {

    private MainActivityView view;
    private Shop shop;
    private Discounting discounter;
    private Presenter presenter;

    private Product egg;
    private Product apple;
    private Product pineapple;
    private Product rice;
    private Product juice;

    @Before
    public void setUp() {
        view = mock(MainActivityView.class);
        shop = mock(Shop.class);
        discounter = mock(Discounting.class);

        egg = new Product("egg", 1.0, 2.0, Discount.NONE);
        apple = new Product("apple", 0.5, 1.1, Discount.NONE);
        pineapple = new Product("pineapple", 3.0, 5.5, Discount.THREEFORTWO);
        rice = new Product("rice", 1.5, 3.0, Discount.NONE);
        juice = new Product("juice", 0.7, 3.0, Discount.BUYTENSAVETENPERCENT);

        presenter = new Presenter(view, shop, discounter);
    }

    @Test
    public void onResume_presenter_tells_view_to_show_stock() {
        presenter.onResume();

        verify(view).showShopStock(any(Shop.class));
    }

    @Test
    public void onResume_presenter_tells_view_to_show_shop_balance() {
        presenter.onResume();

        verify(view).showShopBalance(any(String.class));
    }

    @Test
    public void presenter_can_buy_in_stock_for_the_shop() {
        presenter.onResume();
        when(shop.getBalance()).thenReturn(1000.00);
        when(discounter.getBuyCost(any(Product.class), any(Integer.class))).thenReturn(1.0);
        presenter.buyStock(egg, 1);

        verify(shop).setStock(any(String.class), any(Integer.class));
        verify(shop).setBalance(any(double.class));
        verify(view).displayMessage(any(String.class));
    }

    @Test
    public void presenter_buys_stock_at_buy_price() {}

    @Test
    public void if_product_not_in_product_list_presenter_does_not_buy_product() {
        Product matches = new Product("matches", 0.5, 1.0, Discount.NONE);
        presenter.onResume();
        presenter.buyStock(matches, 1);

        verify(shop, times(0)).setStock(any(String.class), any(Integer.class));
        verify(shop, times(0)).setBalance(any(double.class));
        verify(view).displayMessage(any(String.class));
    }

    @Test
    public void if_shop_cannot_afford_product_presenter_does_not_buy_product() {
        presenter.onResume();

        when(shop.getBalance()).thenReturn(0.0);
        when(discounter.getBuyCost(any(Product.class), any(Integer.class))).thenReturn(1.0);
        presenter.buyStock(egg, 1000);

        verify(shop, times(0)).setStock(any(String.class), any(Integer.class));
        verify(shop, times(0)).setBalance(any(double.class));
        verify(view).displayMessage(any(String.class));
    }

    @Test
    public void presenter_can_sell_stock_from_the_shop() {
        presenter.onResume();

        Map<String, Integer> stock = new HashMap();
        stock.put("egg", 100);

        when(shop.getStock()).thenReturn(stock);
        when(shop.getBalance()).thenReturn(1000.00);
        presenter.sellStock(egg, 1);

        verify(shop).setBalance(any(double.class));
        verify(shop).setStock(any(String.class), any(Integer.class));
        verify(view).displayMessage(any(String.class));
    }

    @Test
    public void presenter_sells_stock_at_sell_price() {}

    @Test
    public void if_stock_quantity_too_low_presenter_does_not_sell_stock() {
        presenter.onResume();

        Map<String, Integer> stock = new HashMap();
        stock.put("egg", 1);

        when(shop.getStock()).thenReturn(stock);
        when(shop.getBalance()).thenReturn(1000.00);
        presenter.sellStock(egg, 100);

        verify(shop, times(0)).setBalance(any(double.class));
        verify(shop, times(0)).setStock(any(String.class), any(Integer.class));
        verify(view).displayMessage(any(String.class));
    }

    @Test
    public void on_orderOneButtonTapped_presenter_buys_stock() {
        presenter.onResume();
        when(shop.getBalance()).thenReturn(1000.00);
        when(discounter.getBuyCost(any(Product.class), any(Integer.class))).thenReturn(1.0);
        presenter.orderOneButtonTapped(0);

        verify(shop).setStock(any(String.class), any(Integer.class));
        verify(shop).setBalance(any(double.class));
        verify(view).displayMessage(any(String.class));
    }

    @Test
    public void when_buying_presenter_applies_discounts_before_setting_new_balance() {
        presenter.onResume();

        when(shop.getBalance()).thenReturn(10.00);
        presenter.buyStock(juice, 10);

        verify(discounter).getBuyCost(any(Product.class), any(Integer.class));
    }

}