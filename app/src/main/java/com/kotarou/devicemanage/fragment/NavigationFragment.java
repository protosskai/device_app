package com.kotarou.devicemanage.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;


import com.kotarou.devicemanage.R;

public class NavigationFragment extends BaseFragment implements View.OnClickListener {


    private ImageButton itemMainBtn;
    private ImageButton itemDeviceBtn;
    private ImageButton itemPersonBtn;
    private MainFragment mainFragment;
    private DeviceFragment deviceFragment;
    private PersonFragment personFragment;


    @Override
    public void onClick(View v) {
        setTabSelection(v.getId());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        initView(view);
        setTabSelection(R.id.tab_item_main);
        return view;
    }


    // 初始化视图对象
    private void initView(View view) {
        // 绑定底部菜单点击事件
        // 主页
        LinearLayout layout = view.findViewById(R.id.tab_item_main);
        layout.setOnClickListener(this);
        // 设备详情
        layout = view.findViewById(R.id.tab_item_device);
        layout.setOnClickListener(this);
        // 个人中心
        layout = view.findViewById(R.id.tab_item_person);
        layout.setOnClickListener(this);
        // 获取到按钮对象
        itemMainBtn = view.findViewById(R.id.tab_item_main_btn);
        itemDeviceBtn = view.findViewById(R.id.tab_item_device_btn);
        itemPersonBtn = view.findViewById(R.id.tab_item_person_btn);
    }

    // 设置Tab选中
    @SuppressLint("NonConstantResourceId")
    public void setTabSelection(int id) {
        // 重置按钮图标
        itemMainBtn.setImageResource(R.drawable.item_main);
        itemDeviceBtn.setImageResource(R.drawable.item_device);
        itemPersonBtn.setImageResource(R.drawable.item_person);
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        // 隐藏所有Fragment
        if (mainFragment != null)
            fragmentTransaction.hide(mainFragment);
        if (deviceFragment != null)
            fragmentTransaction.hide(deviceFragment);
        if (personFragment != null)
            fragmentTransaction.hide(personFragment);
        // 设置fragment
        switch (id) {
            case R.id.tab_item_main:
                itemMainBtn.setImageResource(R.drawable.item_main_normal);
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                    fragmentTransaction.add(R.id.main_fragment_content, mainFragment);
                } else {
                    fragmentTransaction.show(mainFragment);
                }
                break;
            case R.id.tab_item_device:
                itemDeviceBtn.setImageResource(R.drawable.item_device_normal);
                if (deviceFragment == null) {
                    deviceFragment = new DeviceFragment();
                    fragmentTransaction.add(R.id.main_fragment_content, deviceFragment);
                } else {
                    fragmentTransaction.show(deviceFragment);
                }
                break;
            case R.id.tab_item_person:
                itemPersonBtn.setImageResource(R.drawable.item_person_normal);
                if (personFragment == null) {
                    personFragment = new PersonFragment();
                    fragmentTransaction.add(R.id.main_fragment_content, personFragment);
                } else {
                    fragmentTransaction.show(personFragment);
                }
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}
