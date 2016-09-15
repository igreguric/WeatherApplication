package com.ferit.ivan.weather_app.commons.volley;

import java.util.List;

public interface ResponseArrayListener<T> {

    public void onResponse(List<T> data);

    public void onError(Object error);

}