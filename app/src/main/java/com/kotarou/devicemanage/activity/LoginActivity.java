package com.kotarou.devicemanage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.common.base.Strings;
import com.kotarou.devicemanage.R;
import com.kotarou.devicemanage.common.HttpException;
import com.kotarou.devicemanage.common.SharePreferenceUtil;
import com.kotarou.devicemanage.presenter.LoginPresenter;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;
import com.xuexiang.xui.widget.textview.supertextview.SuperButton;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "com.kotarou.devicemanage.activity.LoginActivity";

    private SuperButton loginButton;
    private MaterialEditText usernameTxt;
    private MaterialEditText passwordTxt;
    private LoginPresenter mLoginPresenter = new LoginPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(this);
        usernameTxt = findViewById(R.id.username_txt);
        passwordTxt = findViewById(R.id.password_txt);
    }

    @Override
    public void onClick(View v) {
        String username = usernameTxt.getEditValue();
        String password = passwordTxt.getEditValue();
        if (Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(password)) {
            Toast.makeText(this, "用户名或密码不能能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        mLoginPresenter.login(new Observer<Map>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Map map) {
                String token = (String) map.get("token");
                SharePreferenceUtil.putToken(token);
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                if (e instanceof HttpException) {
                    HttpException exception = (HttpException) e;
                    Toast.makeText(LoginActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onComplete() {

            }
        }, username, password);
//        Intent intent = new Intent();
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.setClass(LoginActivity.this, MainActivity.class);
//        startActivity(intent);
    }
}
