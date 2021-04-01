package com.kotarou.devicemanage.presenter;

import com.google.gson.Gson;
import com.kotarou.devicemanage.common.HttpException;
import com.kotarou.devicemanage.entity.DeviceInfo;
import com.kotarou.devicemanage.entity.HttpResult;
import com.kotarou.devicemanage.http.DeviceService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public class DevicePresenter extends BasePresenter {

    private DeviceService mDeviceService = retrofit.create(DeviceService.class);

    public void getDeviceList(Observer<DeviceInfo> observer) {
        Observable observable = mDeviceService.getDeviceList().map(HttpResult::getData)
                .flatMap((Function<Map, Observable<Map>>) map -> {
                    List<Map> l = (List<Map>) map.get("list");
                    return Observable.fromIterable(l);
                }).map(map -> this.MapToObject(map, DeviceInfo.class));
        toSubscribe(observable, observer);
    }

    public void lendDevice(Observer<Integer> observer, int userId, int deviceId, String detail) {
        Observable observable = mDeviceService.lendDevice(userId, deviceId, detail).map(mapHttpResult -> mapHttpResult.getCode());
        toSubscribe(observable, observer);
    }

    public void returnDevice(Observer<Integer> observer, int userId, int deviceId) {
        Observable observable = mDeviceService.returnDevice(userId, deviceId).map(mapHttpResult -> mapHttpResult.getCode());
        toSubscribe(observable, observer);
    }
}
