package com.tm.testapp.viewmodel;

/**
 * Created by srikanth on 05/06/2018.
 */

public interface SplashViewContract {

    interface View extends LifeCycle.View {

        void navigateToMainScreen();
    }

    interface ViewModel extends LifeCycle.ViewModel {
        void getInitialDataFromApi();
    }
}
