package com.tm.testapp.activity;

import android.os.Bundle;

import com.tm.testapp.R;
import com.tm.testapp.fragment.SplashFragment;

/**
 * Created by srikanth on 05/06/2018.
 */

public class SplashActivity extends BaseActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    public void onSetInitialData(Bundle savedInstanceState) {
        getSupportFragmentManager().beginTransaction().replace(R.id.splashContainer, new SplashFragment()).commit();
    }

    @Override
    public void bindingData() {

    }
}
