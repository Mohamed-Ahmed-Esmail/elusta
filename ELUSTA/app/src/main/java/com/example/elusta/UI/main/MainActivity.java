package com.example.elusta.UI.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.elusta.R;
import com.example.elusta.UI.Elusta.ElustaActivity;
import com.example.elusta.UI.base.BaseActivity;
import com.example.elusta.Utills.Constant;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity implements MainMvpView, View.OnClickListener {
    CircleImageView profile_image;
    TextView username, last_name, email, mobile;
    MainPresenter mainPresenter;
    Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter();

        initViews();

        loadData();
    }


    private void initViews() {
        profile_image = findViewById(R.id.profileImageView);
        username = findViewById(R.id.inputUsername);
        last_name = findViewById(R.id.input_last_name);
        email = findViewById(R.id.input_email);
        mobile = findViewById(R.id.input_mobile);
        btn_continue = findViewById(R.id.btn_continue);

        btn_continue.setOnClickListener(this);
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(Constant.SHARED_PREFS, MODE_PRIVATE);
        username.setText(sharedPreferences.getString(Constant.USERNAME, ""));
        last_name.setText(sharedPreferences.getString(Constant.LAST_NAME, ""));
        mobile.setText(sharedPreferences.getString(Constant.MOBILE, ""));
        email.setText(sharedPreferences.getString(Constant.EMAIL, ""));
        Glide.with(MainActivity.this)
                .load(sharedPreferences.getString(Constant.IMAGE,""))
                .into(profile_image);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_continue:
                Intent intent = new Intent(MainActivity.this, ElustaActivity.class);
                startActivity(intent);
                break;
        }

    }
}