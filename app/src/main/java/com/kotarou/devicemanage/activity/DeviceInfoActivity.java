package com.kotarou.devicemanage.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.kotarou.devicemanage.R;
import com.kotarou.devicemanage.entity.DeviceInfo;

public class DeviceInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        Intent intent = getIntent();
        DeviceInfo deviceInfo = (DeviceInfo) intent.getSerializableExtra("deviceInfo");
        System.out.println(deviceInfo);
    }
}
