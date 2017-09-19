package com.elderj.qmarket;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


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
        presenter.buyStock("", 1);

        verify(shop).setStock(any(String.class));
        verify(shop).setBalance(any(double.class));
    }

}