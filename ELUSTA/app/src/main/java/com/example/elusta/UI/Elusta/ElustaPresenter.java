package com.example.elusta.UI.Elusta;

import android.util.Log;

import com.example.elusta.Data.ApiInterface;
import com.example.elusta.Model.APIClient;
import com.example.elusta.Model.ServicesPojoModel;
import com.example.elusta.UI.base.BasePresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ElustaPresenter extends BasePresenter<ElustaMvpView> implements ElustaMvpPresenter {
    private static final String TAG = "ServicesPresenter";

    APIClient apiClient;

    public ElustaPresenter() {
        apiClient = new APIClient();
    }

    @Override
    public void Services(String lang) {

        Observable observable = apiClient.getClient("").create(ApiInterface.class)
                .Services(lang)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver<ServicesPojoModel> observer = new DisposableObserver<ServicesPojoModel>() {

            public void onNext(ServicesPojoModel servicesPojoModel) {
                if (servicesPojoModel.getStatus()) {
                    getMvpView().showData(servicesPojoModel.getData());
                } else {
                    getMvpView().showMessage(servicesPojoModel.getMsg());

                }
            }


            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error : " + e);
                getMvpView().showMessage(e.getMessage());

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };

        observable.subscribeWith(observer);

    }

}

