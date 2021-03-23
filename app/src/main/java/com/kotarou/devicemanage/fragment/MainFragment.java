package com.kotarou.devicemanage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kotarou.devicemanage.R;
import com.kotarou.devicemanage.entity.HttpResult;
import com.kotarou.devicemanage.entity.WeatherEntity;
import com.kotarou.devicemanage.http.WeatherService;
import com.kotarou.devicemanage.utils.HttpUtil;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainFragment extends BaseFragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button weatherButton = view.findViewById(R.id.weatherBtn);
        textView = view.findViewById(R.id.weather_res);
        weatherButton.setOnClickListener(v -> {
            Observable.create((ObservableOnSubscribe<String>) emitter -> {
                System.out.println("工作中");
                emitter.onNext("结果一");
            }).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@io.reactivex.annotations.NonNull String s) {
                            System.out.println("结果为：" + s);
                        }

                        @Override
                        public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        });
        return view;
    }
}
