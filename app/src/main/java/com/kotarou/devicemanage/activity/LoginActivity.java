package com.kotarou.devicemanage.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.kotarou.devicemanage.R;
import com.xuexiang.xui.widget.textview.supertextview.SuperButton;

public class LoginActivity extends BaseActivity {

    private SuperButton loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(e -> {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setClass(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

}
