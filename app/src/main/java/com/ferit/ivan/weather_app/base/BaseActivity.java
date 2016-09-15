package com.ferit.ivan.weather_app.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ivan on 7/4/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected void replaceFragment(int layoutId, @NonNull Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(layoutId, fragment);
        transaction.commit();
    }
}
