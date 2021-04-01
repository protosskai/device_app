package com.kotarou.devicemanage.http;

import com.kotarou.devicemanage.entity.HttpResult;

import java.util.Map;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("admin/login")
    Observable<HttpResult<Map>> login(@Body Map map);
}
