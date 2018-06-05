package com.tm.testapp.activity;

import android.os.Bundle;

import com.tm.testapp.R;
import com.tm.testapp.fragment.SplashFragment;
import com.tm.testapp.fragment.WebsitesRankingFragment;

public class MainActivity extends BaseActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onSetInitialData(Bundle savedInstanceState) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new WebsitesRankingFragment()).commit();
    }

    @Override
    public void bindingData() {

    }
}
