package com.mateuslima.mvpcats.ui.main;

import com.mateuslima.mvpcats.data.network.result.CatResult;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter, MainContract.Model.RetrieveRadomCats {

    private MainContract.View view;
    private MainContract.Model model;

    @Inject
    public MainPresenter(MainContract.View view) {
        this.view = view;
        model = new MainModel();
    }

    @Override
    public void retrieveCats(int qty) {
        model.retrieveRadomCats(this, qty);
    }

    @Override
    public void catsSuccess(List<CatResult> catResultList) {
        view.showCats(catResultList);
    }

    @Override
    public void catsError(String error) {
        view.errorRetrieveCats(error);
    }
}
