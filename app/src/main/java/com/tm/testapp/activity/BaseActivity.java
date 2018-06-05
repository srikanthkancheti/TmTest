package com.tm.testapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by srikanth on 05/06/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    boolean isDataChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        onSetInitialData(savedInstanceState);
    }

    public abstract int getContentView();

    public abstract void onSetInitialData(Bundle savedInstanceState);

    public abstract void bindingData();

    @Override
    protected void onResume() {
        super.onResume();
        if (isDataChanged) {
            isDataChanged = false;
            bindingData();
        }
    }

}
