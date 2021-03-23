package com.kotarou.devicemanage.http;

import com.google.gson.JsonObject;
import com.kotarou.devicemanage.entity.HttpResult;
import com.kotarou.devicemanage.entity.WeatherEntity;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherService {
    @GET("/getWeather.php??city=哈尔滨")
    Call<WeatherEntity> getWeather();
}
