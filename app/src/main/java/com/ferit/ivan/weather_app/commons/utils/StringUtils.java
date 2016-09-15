package com.ferit.ivan.weather_app.commons.utils;

import android.util.Patterns;

/**
 * Created by ivan on 7/14/16.
 */
public class StringUtils {

    public static boolean isTypeOfEmail(CharSequence target){
        return target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
