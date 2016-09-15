package com.ferit.ivan.weather_app.commons.requests;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.ferit.ivan.weather_app.commons.volley.GsonRequest;
import com.ferit.ivan.weather_app.commons.volley.ResponseListener;
import com.ferit.ivan.weather_app.main.model.Data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ivan on 7/4/16.
 */
public class BackendRequest {

    private static BackendRequest sInstance;

    private Data sensorData;

    public static BackendRequest getsInstance(@NonNull Context context){
        if (sInstance == null){
            sInstance = new BackendRequest(context);
        }
        return sInstance;
    }

    private final RequestQueue mRequestQueue;

    private BackendRequest(@NonNull Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void requestPosts(@NonNull final ResponseListener<List<Data>> listener){
        String url = "https://arduino-igreguri.rhcloud.com/sensorfeed.php";

        GsonRequest<Data[]> request = new GsonRequest<>
                (url, Data[].class, null, new Response.Listener<Data[]>() {

            @Override
            public void onResponse(Data[] response) {
                List<Data> data = Arrays.asList(response);
                listener.onResponse(data);
                sensorData = data.get(0);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error);
            }
        });

        mRequestQueue.add(request);

    }

    public Data getSensorData(){
        return sensorData;
    }

}
