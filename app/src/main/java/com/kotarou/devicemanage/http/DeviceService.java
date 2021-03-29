package com.kotarou.devicemanage.http;

import com.kotarou.devicemanage.entity.DeviceInfo;
import com.kotarou.devicemanage.entity.HttpResult;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DeviceService {

    @GET("device/info/list")
    Observable<HttpResult<Map>> getDeviceList();
}
