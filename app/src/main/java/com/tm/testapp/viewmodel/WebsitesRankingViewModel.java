package com.tm.testapp.viewmodel;

import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.tm.testapp.R;
import com.tm.testapp.TestApplication;
import com.tm.testapp.api.CallBackApi;
import com.tm.testapp.model.TopWebsitesModel;
import com.tm.testapp.repository.BaseRepository;
import com.tm.testapp.storage.TmSampleStorage;
import com.tm.testapp.util.DateTimeUtils;
import com.tm.testapp.util.DialogUtil;

import java.util.Calendar;
import java.util.List;

/**
 * Created by srikanth on 05/06/2018.
 */

public class WebsitesRankingViewModel extends BaseViewModel implements WebsitesRankingViewContract.ViewModel {

    WebsitesRankingViewContract.View viewCallback;
    BaseRepository baseRepository;

    public WebsitesRankingViewModel() {
        baseRepository = new BaseRepository(TestApplication.getInstance());
    }

    @Override
    public void getFilterDataFromApi() {

    }

    @Override
    public void onViewResumed() {

    }

    @Override
    public void onViewAttached(@NonNull LifeCycle.View viewCallback) {
        this.viewCallback = (WebsitesRankingViewContract.View) viewCallback;
    }

    @Override
    public void onViewDetached() {
        this.viewCallback = null;
    }

    public void showDatePicker(final String string) {
        DialogUtil.showDatePicker(viewCallback.getActivity().getSupportFragmentManager(), viewCallback.getActivity().getString(R.string.choose), viewCallback.getActivity().getString(R.string.cancel), new DialogUtil.CalendarPickerCallback() {
            @Override
            public void onSelectDate(DialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                String date = DateTimeUtils.convertServerTime(calendar.getTime(), DateTimeUtils.DOB_DATE_PATTERN);
                if (string.equalsIgnoreCase("START_DATE"))
                    viewCallback.setStartDate(date);
                else
                    viewCallback.setEndDate(date);
            }
        });
    }

    public void getFilterData(String startDate, String endDate) {
        try {
            baseRepository.getTopWebsites(startDate, endDate, new CallBackApi<List<TopWebsitesModel>, Throwable>() {
                @Override
                public void onSuccess(List<TopWebsitesModel> topWebsitesModelList) {
                    TmSampleStorage.getObjInstance().setTopWebsitesList(topWebsitesModelList);
                    if (viewCallback != null)
                        viewCallback.bindData(topWebsitesModelList);
                }

                @Override
                public void onError(int httpCode, String errorCode, Object errorObject) {
                    showErrorDialog("No Results Found");
                    viewCallback.clearFilter();
                }

                @Override
                public void onFailure(Throwable fail) {
                    showErrorDialog("No Results Found");
                    viewCallback.clearFilter();
                }

                @Override
                public void onExpired() {
                    showErrorDialog("No Results Found");
                    viewCallback.clearFilter();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showErrorDialog(String title) {
        DialogUtil.showErrorDialog(viewCallback.getActivity(), title, viewCallback.getActivity().getResources().getString(R.string.ok), new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
            }
        });
    }
}
