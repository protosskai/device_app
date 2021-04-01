package com.kotarou.devicemanage.presenter;

import com.kotarou.devicemanage.http.LoginService;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class LoginPresenter extends BasePresenter {

    private LoginService mLoginService = retrofit.create(LoginService.class);

    public void login(Observer<Map> observer, String username, String password) {
        Map map = new HashMap();
        map.put("username", username);
        map.put("password", password);
        Observable observable = mLoginService.login(map).map(new HttpResultFunc<>());
        toSubscribe(observable, observer);
    }

}
