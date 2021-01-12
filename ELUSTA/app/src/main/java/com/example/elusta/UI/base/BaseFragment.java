package com.example.elusta.UI.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.example.elusta.Model.APIClient;
import com.example.elusta.R;
import com.google.android.material.textfield.TextInputLayout;


/**
 * @author Islam
 */

public abstract class BaseFragment extends Fragment implements BaseMvpView {


    private BaseActivity mActivity;
    private Dialog dialog;
    public APIClient apiClient;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();

        }
    }


    @Override
    public void onError(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @Override
    public void requiredField(EditText editText) {
        editText.setError("هذا الحقل مطلوب");
    }

    @Override
    public void requiredField(TextInputLayout textInputLayout) {
        textInputLayout.setError(getString(R.string.errRequiredField));

    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }



    @Override
    public String onDisplayErrorName(String errorCode) {
        if (mActivity != null) {
            return mActivity.onDisplayErrorName(errorCode);
        }
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mActivity != null) {
            if (mActivity.snackbar != null && mActivity.snackbar.isShown()) {
                mActivity.snackbar.dismiss();
            }
        }
    }
}
