package com.kotarou.devicemanage.presenter;


import android.content.Context;

import com.google.gson.Gson;
import com.kotarou.devicemanage.common.HttpException;
import com.kotarou.devicemanage.common.SharePreferenceUtil;
import com.kotarou.devicemanage.entity.HttpResult;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class BasePresenter {
    private final String baseUrl = "http://192.168.199.101:8080/";

    Retrofit retrofit;
    private final int DEFAULT_TIMEOUT = 5;
    private Gson mGson;

    public BasePresenter() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Request.Builder requestBuilder = request.newBuilder();
                    HttpUrl url = request.url();
                    HttpUrl.Builder urlBuilder = url.newBuilder();
                    requestBuilder.url(urlBuilder.build())
                            .method(request.method(), request.body())
                            .addHeader("X-token", SharePreferenceUtil.getToken());
                    return chain.proceed(requestBuilder.build());
                })
                .build();
        this.retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        this.mGson = new Gson();
    }

    public static <T> void toSubscribe(Observable<T> o, Observer<T> s) {
        o.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    public class HttpResultFunc<T> implements Function<HttpResult<T>, T> {

        @Override
        public T apply(@NonNull HttpResult<T> tHttpResult) throws Exception {
            if (tHttpResult.getCode() != 20000) {
                System.out.println(tHttpResult.getCode());
                System.out.println(tHttpResult.getMessage());
                throw new HttpException(tHttpResult.getCode(), tHttpResult.getMessage());
            }
            return tHttpResult.getData();
        }
    }


    public <T> T MapToObject(Map map, Class<T> classOfT) {
        String json = this.mGson.toJson(map);
        return this.mGson.fromJson(json, classOfT);
    }
}
