package com.elderj.qmarket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class PresenterTest {

    private MainActivityView view;
    private Presenter presenter;

    @Before
    public void setUp() {
        view = mock(MainActivityView.class);
        presenter = new Presenter(view);
    }

    @Test
    public void onResume_presenter_tells_view_to_show_base_products() {
        presenter.onResume();

        verify(view).showBaseProducts(anyListOf(String.class));
    }

    @Test
    public void onResume_presenter_tells_view_to_load_base_supermarket() {
        presenter.onResume();

        verify(view).showBaseSupermarket(any(Supermarket.class));
    }


}