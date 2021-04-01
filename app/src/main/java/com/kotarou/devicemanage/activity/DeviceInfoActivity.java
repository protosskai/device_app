package com.kotarou.devicemanage.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.kotarou.devicemanage.R;
import com.kotarou.devicemanage.entity.DeviceInfo;
import com.kotarou.devicemanage.presenter.DevicePresenter;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class DeviceInfoActivity extends BaseActivity implements View.OnClickListener {

    private TextView deviceIdTxt;
    private TextView deviceNameTxt;
    private TextView principalUserTxt;
    private TextView maintainTxt;
    private TextView lendTxt;
    private TextView reverseTxt;
    private TextView deviceDetailTxt;
    private TextView createTimeTxt;
    private Button lendDeviceBtn;
    private Button returnDeviceBtn;
    private DeviceInfo deviceInfo;
    private DevicePresenter devicePresenter = new DevicePresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        initView();
    }


    private void initView() {
        Intent intent = getIntent();
        DeviceInfo deviceInfo = (DeviceInfo) intent.getSerializableExtra("deviceInfo");
        this.deviceInfo = deviceInfo;
        // 绑定view
        deviceIdTxt = findViewById(R.id.device_id_txt);
        deviceNameTxt = findViewById(R.id.device_name_txt);
        principalUserTxt = findViewById(R.id.principal_user_txt);
        maintainTxt = findViewById(R.id.maintain_txt);
        lendTxt = findViewById(R.id.lend_txt);
        reverseTxt = findViewById(R.id.reverse_txt);
        deviceDetailTxt = findViewById(R.id.device_detail_txt);
        createTimeTxt = findViewById(R.id.create_time_txt);
        lendDeviceBtn = findViewById(R.id.lend_device_btn);
        returnDeviceBtn = findViewById(R.id.return_device_btn);
        lendDeviceBtn.setOnClickListener(this);
        returnDeviceBtn.setOnClickListener(this);

        // 初始化界面
        deviceIdTxt.setText(String.valueOf(deviceInfo.getId()));
        deviceNameTxt.setText(deviceInfo.getDeviceName());
        principalUserTxt.setText(deviceInfo.getPrincipalUser());
        maintainTxt.setText(deviceInfo.getIsMaintain() == 1 ? "是" : "否");
        lendTxt.setText(deviceInfo.getIsLended() == 1 ? "是" : "否");
        reverseTxt.setText(deviceInfo.getIsReverse() == 1 ? "是" : "否");
        deviceDetailTxt.setText(deviceInfo.getDetail());
        createTimeTxt.setText(deviceInfo.getCreateTime());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lend_device_btn:
                this.lendDevice(1, this.deviceInfo.getId());
                break;
            case R.id.return_device_btn:
                this.returnDevice(1, this.deviceInfo.getId());
                break;
        }
    }

    private void lendDevice(int userId, int deviceId) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("确认借出")
                .setMessage("你确认要借出该设备吗")
                .setPositiveButton("确认", (dialog, which) -> devicePresenter.lendDevice(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        if (integer == 20000) {
                            Toast.makeText(DeviceInfoActivity.this, "成功!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(DeviceInfoActivity.this, "借出失败!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(DeviceInfoActivity.this, "失败!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                }, userId, deviceId, ""))
                .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                .create();
        alertDialog.show();
        Button btnPos = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        Button btnNeg = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        btnPos.setTextColor(Color.RED);
        btnNeg.setTextColor(Color.RED);
    }

    private void returnDevice(int userId, int deviceId) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("确认归还")
                .setMessage("你确认要归还该设备吗")
                .setPositiveButton("确认", (dialog, which) -> devicePresenter.returnDevice(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        if (integer == 20000) {
                            Toast.makeText(DeviceInfoActivity.this, "成功!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(DeviceInfoActivity.this, "归还失败!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Toast.makeText(DeviceInfoActivity.this, "失败!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                }, userId, deviceId))
                .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                .create();
        alertDialog.show();
        Button btnPos = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        Button btnNeg = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        btnPos.setTextColor(Color.RED);
        btnNeg.setTextColor(Color.RED);
    }
}
