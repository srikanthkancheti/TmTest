package com.tm.testapp.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tm.testapp.R;
import com.tm.testapp.databinding.FragmentSplashBinding;
import com.tm.testapp.util.ActivityHelper;
import com.tm.testapp.viewmodel.LifeCycle;
import com.tm.testapp.viewmodel.SplashViewContract;
import com.tm.testapp.viewmodel.SplashViewModel;

/**
 * Created by srikanth on 05/06/2018.
 */

public class SplashFragment extends BaseFragment implements SplashViewContract.View {

    SplashViewModel mViewModel;
    FragmentSplashBinding mBinding;
    @Override
    protected LifeCycle.ViewModel getViewModel() {
        return mViewModel;
    }

    public SplashFragment(){
        mViewModel = new SplashViewModel();
    }

    @Override
    public void onBackButtonPressed() {
        getActivity().onBackPressed();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_splash, container, false);
        mBinding = DataBindingUtil.bind(root);

        mBinding.tvSplash.setText(getResources().getText(R.string.splash_text));

        return root;
    }

    @Override
    public void navigateToMainScreen() {
        ActivityHelper.openMainScreen(getActivity());
        getActivity().finish();
    }
}
