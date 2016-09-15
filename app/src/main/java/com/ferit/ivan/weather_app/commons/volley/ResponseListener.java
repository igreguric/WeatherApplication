package com.ferit.ivan.weather_app.commons.volley;

public interface ResponseListener<T> {

    public void onResponse(T data);

    public void onError(Object error);

}