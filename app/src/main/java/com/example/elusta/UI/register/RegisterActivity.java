package com.example.elusta.UI.register;

import android.os.Bundle;

import com.example.elusta.R;
import com.example.elusta.UI.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements RegisterMvpView {
    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
