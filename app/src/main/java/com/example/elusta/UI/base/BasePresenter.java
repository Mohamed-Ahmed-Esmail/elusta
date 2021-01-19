package com.example.elusta.UI.base;



/**
 * @author Islam
 * @date 10/12/2018
 */

public class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {


    private V mMvpView;

    public BasePresenter() {

    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public V getMvpView() {
        return mMvpView;
    }

}
