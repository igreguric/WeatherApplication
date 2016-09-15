package com.ferit.ivan.weather_app.splash.activity;

import android.content.Intent;
import android.os.Bundle;

import com.ferit.ivan.weather_app.R;
import com.ferit.ivan.weather_app.base.BaseActivity;
import com.ferit.ivan.weather_app.main.activity.MainActivity;

/**
 * Created by ivan on 7/14/16.
 */
public class SplashActivity extends BaseActivity {

    private final int SPLASH_DURATION = 2000;

    private  final android.os.Handler mHandler = new android.os.Handler();

    private  final Runnable mNextActivityRunnable = new Runnable() {
        @Override
        public void run() {
            startNextActivity();
        }
    };

    private void startNextActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mHandler.postDelayed(mNextActivityRunnable, SPLASH_DURATION);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mNextActivityRunnable);
    }
    }