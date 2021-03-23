package com.kotarou.devicemanage;

import android.app.Application;
import android.content.Context;

import com.kotarou.devicemanage.common.ImageLoaderManager;

public class MyApplication extends Application {

    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //全局配置image-loader
        ImageLoaderManager.getInstance();
    }

    public static Context getContext() {
        return mContext;
    }
}
