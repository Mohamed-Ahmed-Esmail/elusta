package com.example.elusta.UI.base;

import android.widget.EditText;

import androidx.annotation.StringRes;

import com.google.android.material.textfield.TextInputLayout;


/**
 * @author Islam
 * @date 10/12/2018
 */

public interface BaseMvpView {

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    void onError(@StringRes int resId);

    void hideKeyboard();

    void requiredField(EditText editText);

    void requiredField(TextInputLayout editText);

    String onDisplayErrorName(String errorCode);

}
