package com.example.elusta.UI.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elusta.Model.LoginPojoModel;
import com.example.elusta.R;
import com.example.elusta.UI.base.BaseActivity;
import com.example.elusta.UI.main.MainActivity;
import com.example.elusta.UI.register.RegisterActivity;
import com.example.elusta.Utills.Constant;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity implements LoginMvpView, View.OnClickListener {
    public TextInputEditText tv_email, tv_password;
    public Button btn_sign_in;
    public TextView forgotPassword, sign_up;
    private ProgressDialog LoadingBar;
    public LoginMvpView view;
    public LoginPojoModel service;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(view, service);
        presenter.onAttach(this);

        initViews();

    }

    private void initViews() {
        tv_email = findViewById(R.id.inputemail1);
        tv_password = findViewById(R.id.inputpassword1);
        btn_sign_in = findViewById(R.id.btn_sign_in);
        forgotPassword = findViewById(R.id.forget_password);
        sign_up = findViewById(R.id.sign_up);

        btn_sign_in.setOnClickListener(this);
        sign_up.setOnClickListener(this);

        LoadingBar = new ProgressDialog(this);

    }


    private void Login() {

        String email = tv_email.getText().toString();
        String password = tv_password.getText().toString();

        if (!isEmailValid(email)) {
            showError(tv_email, "Email is not valid");
        } else if (password.isEmpty() || password.length() < 8) {
            showError(tv_password, "Password be greated than 8 latter");
        } else {
            LoadingBar.setTitle("Login");
            LoadingBar.setMessage("Please wait,while your credentials");
            LoadingBar.setCanceledOnTouchOutside(false);
            LoadingBar.show();

            presenter.login(tv_email.getText().toString(), tv_password.getText().toString());
        }
    }

    /**
     * method is used for checking valid email id format.
     *
     * @param email
     * @return boolean true for valid false for invalid
     */
    public static boolean isEmailValid(String email) {
        // like ds@4s-sys.com
        String expression = "[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.+[a-z]+";

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    private void showError(TextInputEditText field, String text) {
        field.setError(text);
        field.requestFocus();
    }

    @Override
    public void showData(LoginPojoModel loginPojoModel) {
        LoadingBar.dismiss();
        saveData(loginPojoModel);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public String getUsername() {
        return tv_email.getText().toString();
    }

    @Override
    public void showUsernameError(int resId) {
        tv_email.setError(getString(resId));

    }

    @Override
    public String getPassword() {
        return tv_password.getText().toString();
    }

    @Override
    public void showPasswordError(int resId) {
        tv_password.setError(getString(resId));

    }

    public void saveData(LoginPojoModel loginPojoModel) {
        SharedPreferences sharedPreferences = getSharedPreferences(Constant.SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.USERNAME, loginPojoModel.getData().getFirst_name());
        editor.putString(Constant.LAST_NAME, loginPojoModel.getData().getLast_name());
        editor.putString(Constant.MOBILE, loginPojoModel.getData().getMobile());
        editor.putString(Constant.EMAIL, loginPojoModel.getData().getEmail());
        editor.putString(Constant.IMAGE, loginPojoModel.getData().getPhoto());
        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_sign_in:
                Login();
                break;
            case R.id.sign_up:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}


