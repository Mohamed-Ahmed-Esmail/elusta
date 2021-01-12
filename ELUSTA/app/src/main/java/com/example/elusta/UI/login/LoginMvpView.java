package com.example.elusta.UI.login;

import com.example.elusta.Model.LoginPojoModel;
import com.example.elusta.UI.base.BaseMvpView;

public interface LoginMvpView extends BaseMvpView {
    void showData(LoginPojoModel loginPojoModel);


    String getUsername();

    void showUsernameError(int resId);

    String getPassword();

    void showPasswordError(int resId);


}
