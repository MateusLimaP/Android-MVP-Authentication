package com.mateuslima.mvpcats.ui.main;

import com.mateuslima.mvpcats.data.network.result.CatResult;

import java.util.List;

public interface MainContract {

    interface Model{

        interface RetrieveRadomCats{
            void catsSuccess(List<CatResult> catResultList);
            void catsError(String error);
        }
        void retrieveRadomCats(RetrieveRadomCats retrieveRadomCats, int qty);
    }

    interface View{
        void showCats(List<CatResult> catResultList);
        void errorRetrieveCats(String error);
    }

    interface Presenter{
        void retrieveCats(int qty);
    }
}
