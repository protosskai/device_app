package com.kotarou.devicemanage.http;


import com.kotarou.devicemanage.entity.HttpResult;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DeviceService {

    // 获取设备列表
    @GET("device/info/list")
    Observable<HttpResult<Map>> getDeviceList();

    // 借出设备
    @GET("device/lend/lend")
    Observable<HttpResult<Map>> lendDevice(@Query("userId") int userId, @Query("deviceId") int deviceId, @Query("detail") String detail);

    // 归还设备
    @GET("device/lend/returnDevice")
    Observable<HttpResult<Map>> returnDevice(@Query("userId") int userId, @Query("deviceId") int deviceId);
}
