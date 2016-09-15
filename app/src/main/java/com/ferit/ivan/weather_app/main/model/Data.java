package com.ferit.ivan.weather_app.main.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ivan on 7/14/16.
 */
public class Data implements Serializable {

    private long id;
    private String date;
    private String s1;
    private String s2;
    private String s3;
    private String s4;

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public String getS3() {
        return s3;
    }

    public String getS4() {
        return s4;
    }

}
