package com.tm.testapp.viewmodel;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

/**
 * Created by srikanth on 05/06/2018.
 */

public class LifeCycle {

    public interface View {
        FragmentActivity getActivity();
    }

    public interface ViewModel {

        void onViewResumed();

        void onViewAttached(@NonNull LifeCycle.View viewCallback);

        void onViewDetached();
    }
}
