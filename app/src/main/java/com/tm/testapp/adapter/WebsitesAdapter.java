package com.tm.testapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tm.testapp.R;
import com.tm.testapp.adapter.holder.LoadingMoreViewHolder;
import com.tm.testapp.adapter.holder.TopWebsitesViewHolder;
import com.tm.testapp.databinding.TopWebsitesItemStringBinding;
import com.tm.testapp.interfaces.WebsiteListItemsListener;
import com.tm.testapp.model.TopWebsitesModel;

import java.util.List;

/**
 * Created by srikanth on 05/06/2018.
 */

public class WebsitesAdapter extends BaseAdapter {
    private final Context context;
    List<TopWebsitesModel> mTitleSelectInterfaceList;
    private WebsiteListItemsListener websiteListItemsListener;

    public WebsitesAdapter(Context context) {
        setHasFooter(false);
        this.context = context;
    }

    public List<TopWebsitesModel> getModelList() {
        return mTitleSelectInterfaceList;
    }

    public WebsitesAdapter setModelList(List<TopWebsitesModel> modelList, WebsiteListItemsListener websiteListItemsListener) {
        mTitleSelectInterfaceList = modelList;
        this.websiteListItemsListener = websiteListItemsListener;
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = TopWebsitesViewHolder.getView(parent);
            TopWebsitesViewHolder pvh = new TopWebsitesViewHolder(view);
            return pvh;
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_loading_more, parent, false);
            LoadingMoreViewHolder pvh = new LoadingMoreViewHolder(v);
            return pvh;
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TopWebsitesViewHolder) {
            TopWebsitesViewHolder viewHolder = (TopWebsitesViewHolder) holder;
            TopWebsitesItemStringBinding mBinding = viewHolder.mBinding;
            final TopWebsitesModel topWebsitesModel = mTitleSelectInterfaceList.get(position);
            mBinding.tvWebsiteName.setText(topWebsitesModel.getWebsiteName());
            mBinding.tvVisitDate.setText(topWebsitesModel.getVisitDate());
            mBinding.tvTotalVisits.setText(topWebsitesModel.getTotalVisits());

            mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    websiteListItemsListener.WebsiteListItemClicked(position);
                }
            });
        } else if (holder instanceof LoadingMoreViewHolder) {
            LoadingMoreViewHolder loadingMoreViewHolder = (LoadingMoreViewHolder) holder;
            if (isStillLoadingMore) {
                loadingMoreViewHolder.mProgressBar.setVisibility(View.VISIBLE);
            } else {
                loadingMoreViewHolder.mProgressBar.setVisibility(View.GONE);
            }
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mTitleSelectInterfaceList.size() + (isHasFooter ? 1 : 0);
    }


    private boolean isPositionFooter(int position) {
        return (position >= mTitleSelectInterfaceList.size()) && isHasFooter;
    }


    @Override
    public int getItemViewType(int position) {
        if (isPositionFooter(position)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }

    }
}
