package com.tm.testapp.repository;

import android.content.Context;

import com.tm.testapp.api.CallBackApi;
import com.tm.testapp.api.CallerAPI;
import com.tm.testapp.api.CallerApiRetrofit;
import com.tm.testapp.model.TopWebsitesModel;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by srikanth on 05/06/2018.
 */

public class BaseRepository {

    public static final String TAG_API = "TAG_API";
    CallerAPI mCallerApi;
    Context mContext;
    boolean value = false;

    public BaseRepository(Context context) {
        mContext = context;
        //If real server
        mCallerApi = new CallerApiRetrofit(context);

    }

    public CallerAPI getCallerApi() {
        return mCallerApi;
    }

    public void getAllTopWebsites(final CallBackApi<List<TopWebsitesModel>, Throwable> callBack) throws IOException {
        Call<List<TopWebsitesModel>> call = getCallerApi().getConfigurations();
        call.enqueue(new Callback<List<TopWebsitesModel>>() {
            @Override
            public void onResponse(Call<List<TopWebsitesModel>> call, Response<List<TopWebsitesModel>> response) {
                if (response.isSuccessful()) {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onProcessError(response.code(), response.message(), response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<TopWebsitesModel>> call, Throwable t) {
                callBack.onFailure(t);
            }
        });
    }

    public void getTopWebsites(String start, String end, final CallBackApi<List<TopWebsitesModel>, Throwable> callBack) throws IOException {
        Call<List<TopWebsitesModel>> call = getCallerApi().getTopWebsites(start, end);
        call.enqueue(new Callback<List<TopWebsitesModel>>() {
            @Override
            public void onResponse(Call<List<TopWebsitesModel>> call, Response<List<TopWebsitesModel>> response) {
                if (response.isSuccessful()) {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onProcessError(response.code(), response.message(), response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<TopWebsitesModel>> call, Throwable t) {
                callBack.onFailure(t);
            }
        });
    }

}
