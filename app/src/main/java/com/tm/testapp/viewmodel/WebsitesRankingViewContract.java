package com.tm.testapp.viewmodel;

import com.tm.testapp.model.TopWebsitesModel;

import java.util.List;

/**
 * Created by srikanth on 05/06/2018.
 */

public interface WebsitesRankingViewContract {

    interface View extends LifeCycle.View {

        void bindData(List<TopWebsitesModel> mTopWebsitesList);

        void setStartDate(String startDate);

        void setEndDate(String endDate);

        void clearFilter();
    }

    interface ViewModel extends LifeCycle.ViewModel {
        void getFilterDataFromApi();
    }
}
