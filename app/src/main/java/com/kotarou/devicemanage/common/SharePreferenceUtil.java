package com.kotarou.devicemanage.common;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceUtil {

    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static String getToken() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("data", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");
        return token;
    }

    public static void putToken(String token) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences("data", Context.MODE_PRIVATE)
                .edit();
        editor.putString("token", token);
        editor.apply();
    }
}
