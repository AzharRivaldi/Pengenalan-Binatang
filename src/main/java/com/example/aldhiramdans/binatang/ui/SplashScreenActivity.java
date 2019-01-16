package com.example.aldhiramdans.binatang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.aldhiramdans.binatang.Application;
import com.example.aldhiramdans.binatang.R;

public class SplashScreenActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application.getInstance().runOnUIThreadDelay(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
                finish();
            }
        }, 1500);
    }
}
