package com.example.elusta.UI.base;

/**
 * Created by Islam on 10/12/2018.
 */

public interface BaseMvpPresenter <V extends BaseMvpView> {

    void onAttach(V mvpView);

    void onDetach();


}