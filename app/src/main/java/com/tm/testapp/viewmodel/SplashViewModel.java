package com.tm.testapp.viewmodel;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.tm.testapp.TestApplication;
import com.tm.testapp.api.CallBackApi;
import com.tm.testapp.model.TopWebsitesModel;
import com.tm.testapp.repository.BaseRepository;
import com.tm.testapp.storage.TmSampleStorage;

import java.util.List;

/**
 * Created by srikanth on 05/06/2018.
 */

public class SplashViewModel extends BaseViewModel implements SplashViewContract.ViewModel {

    SplashViewContract.View viewCallback;
    BaseRepository baseRepository;

    public SplashViewModel(){
        baseRepository = new BaseRepository(TestApplication.getInstance());
    }
    @Override
    public void onViewResumed() {
        getInitialDataFromApi();
    }

    @Override
    public void onViewAttached(@NonNull LifeCycle.View viewCallback) {
        this.viewCallback = (SplashViewContract.View) viewCallback;
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void getInitialDataFromApi() {
        try {
            baseRepository.getAllTopWebsites(new CallBackApi<List<TopWebsitesModel>, Throwable>() {
                @Override
                public void onSuccess(List<TopWebsitesModel> topWebsitesModelList) {
                    TmSampleStorage.getObjInstance().setTopWebsitesList(topWebsitesModelList);
                    if (viewCallback != null)
                        viewCallback.navigateToMainScreen();
                }

                @Override
                public void onError(int httpCode, String errorCode, Object errorObject) {
                    Toast.makeText(viewCallback.getActivity(), errorCode, Toast.LENGTH_LONG).show();
//                    showErrorDialog();
                }

                @Override
                public void onFailure(Throwable fail) {
                    Toast.makeText(viewCallback.getActivity(), "Service Fail", Toast.LENGTH_LONG).show();
//                    showErrorDialog();
                }

                @Override
                public void onExpired() {
                    Toast.makeText(viewCallback.getActivity(), "Service Expired", Toast.LENGTH_LONG).show();
//                    showErrorDialog();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
