package com.tm.testapp.api;

import com.tm.testapp.model.TopWebsitesModel;

import java.util.List;

import retrofit2.Call;

/**
 * Created by srikanth on 05/06/2018.
 */

public interface CallerAPI {

    Call<List<TopWebsitesModel>> getConfigurations();

    Call<List<TopWebsitesModel>> getTopWebsites(String start, String end);
}
