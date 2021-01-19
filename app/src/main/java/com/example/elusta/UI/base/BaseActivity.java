package com.example.elusta.UI.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.elusta.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

/**
 * @author Islam
 * @date 10/12/2018
 */

public class BaseActivity extends AppCompatActivity implements BaseMvpView, BaseFragment.Callback {

    private Dialog dialog;
    public Snackbar snackbar;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "يوجد خطأ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showMessage(int resId) {
        showMessage(getString(resId));
    }


    @Override
    public void onError(int resId) {
        // onError(getString(resId));
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void requiredField(EditText editText) {
        editText.setError(getString(R.string.errRequiredField));

    }

    @Override
    public void requiredField(TextInputLayout textInputLayout) {
        textInputLayout.setError(getString(R.string.errRequiredField));

    }



    @Override
    public void onFragmentAttached() {
    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public String onDisplayErrorName(String errorCode) {
        return getResources().getString(R.string.network_error) + errorCode;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (snackbar != null && snackbar.isShown()) {
            snackbar.dismiss();
        }
    }
}
