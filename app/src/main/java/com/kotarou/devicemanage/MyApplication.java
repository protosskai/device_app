package com.kotarou.devicemanage;

import android.app.Application;
import android.content.Context;

import com.kotarou.devicemanage.common.ImageLoaderManager;
import com.kotarou.devicemanage.common.SharePreferenceUtil;
import com.kotarou.devicemanage.presenter.BasePresenter;
import com.xuexiang.xui.XUI;

public class MyApplication extends Application {

    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //全局配置image-loader
        ImageLoaderManager.getInstance();
        XUI.init(this); //初始化UI框架
        XUI.debug(true);  //开启UI框架调试日志
        SharePreferenceUtil.init(getContext());
    }

    public static Context getContext() {
        return mContext;
    }
}
