package com.tm.testapp.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tm.testapp.R;
import com.tm.testapp.adapter.WebsitesAdapter;
import com.tm.testapp.databinding.FragmentWebsitesRankingBinding;
import com.tm.testapp.interfaces.WebsiteListItemsListener;
import com.tm.testapp.model.TopWebsitesModel;
import com.tm.testapp.storage.TmSampleStorage;
import com.tm.testapp.viewmodel.LifeCycle;
import com.tm.testapp.viewmodel.WebsitesRankingViewContract;
import com.tm.testapp.viewmodel.WebsitesRankingViewModel;

import java.util.List;

/**
 * Created by srikanth on 05/06/2018.
 */

public class WebsitesRankingFragment extends BaseFragment implements WebsitesRankingViewContract.View {

    private WebsitesRankingViewModel mViewModel;
    private FragmentWebsitesRankingBinding mBinding;
    private WebsitesAdapter websitesAdapter;
    private List<TopWebsitesModel> mTopWebsitesList;
    private List<TopWebsitesModel> mFilterList;

    @Override
    protected LifeCycle.ViewModel getViewModel() {
        return mViewModel;
    }

    public WebsitesRankingFragment() {
        mViewModel = new WebsitesRankingViewModel();
    }

    @Override
    public void onBackButtonPressed() {
        getActivity().onBackPressed();
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int id = view.getId();

            if (id == R.id.layAll) {
                OnAllClick();
            } else if (id == R.id.layFilter) {
                OnFilterClick();
            } else if (id == R.id.edtStartDate) {
                mViewModel.showDatePicker("START_DATE");
            } else if (id == R.id.edtEndDate) {
                mViewModel.showDatePicker("END_DATE");
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_websites_ranking, container, false);
        mBinding = DataBindingUtil.bind(root);
        mTopWebsitesList = TmSampleStorage.getObjInstance().getTopWebsitesList();
        bindData(mTopWebsitesList);
        OnAllClick();
        BindOnClickListeners();
        return root;
    }

    private void BindOnClickListeners() {
        mBinding.layAll.setOnClickListener(mOnClickListener);
        mBinding.layFilter.setOnClickListener(mOnClickListener);
        mBinding.edtStartDate.setOnClickListener(mOnClickListener);
        mBinding.edtEndDate.setOnClickListener(mOnClickListener);
    }

    private void OnAllClick() {
        mBinding.layAll.setBackground(getResources().getDrawable(R.drawable.half_rounded_dark));
        mBinding.layFilter.setBackground(getResources().getDrawable(R.drawable.half_rounded_light));
        mTopWebsitesList = TmSampleStorage.getObjInstance().getTopWebsitesList();
        bindData(mTopWebsitesList);
    }

    private void OnFilterClick() {
        String startDate = mBinding.edtStartDate.getText().toString();
        String endDate = mBinding.edtEndDate.getText().toString();
        if (startDate.length() > 0 && endDate.length() > 0) {
            mBinding.layAll.setBackground(getResources().getDrawable(R.drawable.half_rounded_light));
            mBinding.layFilter.setBackground(getResources().getDrawable(R.drawable.half_rounded_dark));
            mViewModel.getFilterData(startDate, endDate);
        }
    }

    @Override
    public void bindData(List<TopWebsitesModel> mTopWebsitesList) {
        LinearLayoutManager storeLinearLayoutManager = new LinearLayoutManager(getContext());
        mBinding.listWebsites.setHasFixedSize(true);
        mBinding.listWebsites.setLayoutManager(storeLinearLayoutManager);
        mBinding.listWebsites.setNestedScrollingEnabled(false);
        mBinding.listWebsites.setItemAnimator(new DefaultItemAnimator());

        if (mTopWebsitesList != null && mTopWebsitesList.size() > 0) {
            websitesAdapter = new WebsitesAdapter(getActivity());
            websitesAdapter.setHasFooter(true);
            websitesAdapter.setModelList(mTopWebsitesList, new WebsiteListItemsListener() {
                @Override
                public void WebsiteListItemClicked(int position) {
                }

            });
            mBinding.listWebsites.setAdapter(websitesAdapter);
        }
    }

    @Override
    public void setStartDate(String startDate) {
        mBinding.edtStartDate.setText(startDate);
    }

    @Override
    public void setEndDate(String endDate) {
        mBinding.edtEndDate.setText(endDate);
    }

    @Override
    public void clearFilter() {
        mBinding.edtStartDate.setText("");
        mBinding.edtEndDate.setText("");
    }
}
