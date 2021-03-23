package com.kotarou.devicemanage.entity;


import java.util.List;

public class WeatherEntity {
    private int status;
    private String message;
    private Result result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}

class Result {
    private Location location;
    private Now now;
    private List<Forecast> forecasts;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }
}

//"result": {
//        "location": {
//        "country": "中国",
//        "province": "黑龙江省",
//        "city": "哈尔滨市",
//        "name": "哈尔滨",
//        "id": "230100"
//        },
//        "now": {
//        "text": "晴",
//        "temp": 1,
//        "feels_like": -1,
//        "rh": 52,
//        "wind_class": "3级",
//        "wind_dir": "西风",
//        "uptime": "20210321192000"
//        },
//        "forecasts": [
//        {
//        "text_day": "雨夹雪",
//        "text_night": "晴",
//        "high": 3,
//        "low": -6,
//        "wc_day": "4~5级",
//        "wd_day": "西北风",
//        "wc_night": "3~4级",
//        "wd_night": "西北风",
//        "date": "2021-03-21",
//        "week": "星期日"
//        },
//        ]
//        },

class Location {
    private String country;
    private String province;
    private String city;
    private String name;
    private String id;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Now {
    private String text;
    private int temp;
    private int feels_like;
    private int rh;
    private String wind_class;
    private String wind_dir;
    private String uptime;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(int feels_like) {
        this.feels_like = feels_like;
    }

    public int getRh() {
        return rh;
    }

    public void setRh(int rh) {
        this.rh = rh;
    }

    public String getWind_class() {
        return wind_class;
    }

    public void setWind_class(String wind_class) {
        this.wind_class = wind_class;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
}

class Forecast {
    private String text_day;
    private String text_night;
    private int high;
    private int low;
    private String wc_day;
    private String wd_day;
    private String wc_night;
    private String wd_night;
    private String date;
    private String week;

    public String getText_day() {
        return text_day;
    }

    public void setText_day(String text_day) {
        this.text_day = text_day;
    }

    public String getText_night() {
        return text_night;
    }

    public void setText_night(String text_night) {
        this.text_night = text_night;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public String getWc_day() {
        return wc_day;
    }

    public void setWc_day(String wc_day) {
        this.wc_day = wc_day;
    }

    public String getWd_day() {
        return wd_day;
    }

    public void setWd_day(String wd_day) {
        this.wd_day = wd_day;
    }

    public String getWc_night() {
        return wc_night;
    }

    public void setWc_night(String wc_night) {
        this.wc_night = wc_night;
    }

    public String getWd_night() {
        return wd_night;
    }

    public void setWd_night(String wd_night) {
        this.wd_night = wd_night;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}