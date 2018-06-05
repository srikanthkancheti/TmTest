package com.tm.testapp.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.View;

import com.tm.testapp.viewmodel.LifeCycle;

/**
 * Created by srikanth on 05/06/2018.
 */

public abstract class BaseFragment extends DialogFragment implements LifeCycle.View, View.OnKeyListener  {

    protected abstract LifeCycle.ViewModel getViewModel();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                onBackButtonPressed();
                return true;
            }
        }

        return false;
    }

    public abstract void onBackButtonPressed();

    @Override
    public void onResume() {

        super.onResume();
        LifeCycle.ViewModel viewModel = getViewModel();
        if (viewModel != null) viewModel.onViewResumed();
    }

    @Override
    public void onStart() {
        super.onStart();
        LifeCycle.ViewModel viewModel = getViewModel();
        if (viewModel != null) viewModel.onViewAttached(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        LifeCycle.ViewModel viewModel = getViewModel();
        if (viewModel != null) viewModel.onViewDetached();
    }
}
