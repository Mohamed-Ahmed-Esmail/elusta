package com.example.elusta.UI.login;

import android.util.Log;

import com.example.elusta.Data.ApiInterface;
import com.example.elusta.Model.APIClient;
import com.example.elusta.Model.LoginPojoModel;
import com.example.elusta.R;
import com.example.elusta.UI.base.BasePresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginMvpView> implements LoginMvpPresenter {

    private static final String TAG = "LoginPresenter";
    APIClient apiClient;
    public LoginMvpView view;
    public LoginPojoModel service;

    public LoginPresenter(LoginMvpView view, LoginPojoModel service) {
        apiClient = new APIClient();
        this.view = view;
        this.service = service;

    }

    @Override
    public void login(String name, String pass) {

        Observable observable = apiClient.getClient("").create(ApiInterface.class)
                .loginUser(3, name, pass, "password")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver<LoginPojoModel> observer = new DisposableObserver<LoginPojoModel>() {

            @Override
            public void onNext(LoginPojoModel loginResponse) {
                if (loginResponse.getStatus("mohamed", "ahmed")) {
                    getMvpView().showData(loginResponse);

                } else {
                    getMvpView().showMessage(loginResponse.getMsg());

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

    public void login() {
        String username = view.getUsername();
        if (username.isEmpty()) {
            view.showUsernameError(R.string.Username_Error);
            return;
        }
        String password = view.getPassword();
        if (password.isEmpty()){
            view.showPasswordError(R.string.Password_Error);
            return;
        }

    }
}