package com.elderj.qshop;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PresenterTest {

    private MainActivityView view;
    private Shop shop;
    private Presenter presenter;

    @Before
    public void setUp() {
        view = mock(MainActivityView.class);
        shop = mock(Shop.class);
        presenter = new Presenter(view, shop);
    }

    @Test
    public void onResume_presenter_tells_view_to_show_base_products() {
        presenter.onResume();

        verify(view).showBaseProducts(anyListOf(String.class));
    }

    @Test
    public void onResume_presenter_tells_view_to_load_base_supermarket() {
        presenter.onResume();

        verify(view).showBaseShop(any(Shop.class));
    }

    @Test
    public void presenter_can_buy_in_stock_for_the_supermarket() {
        presenter.onResume();
        when(shop.getBalance()).thenReturn(1000.00);
        presenter.buyStock("eggs", 1);

        verify(shop).setStock(any(String.class));
        verify(shop).setBalance(any(double.class));
    }

    @Test
    public void if_product_not_in_product_list_presenter_does_not_buy_product() {
        presenter.onResume();
        presenter.buyStock("matches", 1);

        verify(shop, times(0)).setStock(any(String.class));
        verify(shop, times(0)).setBalance(any(double.class));
    }

    @Test
    public void if_shop_cannot_afford_product_presenter_does_not_buy_product() {
        presenter.onResume();

        when(shop.getBalance()).thenReturn(0.0);
        presenter.buyStock("eggs", 1000);
        presenter.buyStock("matches", 1);

        verify(shop, times(0)).setStock(any(String.class));
        verify(shop, times(0)).setBalance(any(double.class));
    }

}