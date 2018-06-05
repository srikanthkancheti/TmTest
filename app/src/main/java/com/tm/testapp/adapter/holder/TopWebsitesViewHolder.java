package com.tm.testapp.adapter.holder;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tm.testapp.R;
import com.tm.testapp.databinding.TopWebsitesItemStringBinding;

/**
 * Created by srikanth on 05/06/2018.
 */

public class TopWebsitesViewHolder extends RecyclerView.ViewHolder {

    public TopWebsitesItemStringBinding mBinding;

    public TopWebsitesViewHolder(View itemView) {
        super(itemView);
        mBinding= DataBindingUtil.bind(itemView);
    }

    public static View getView(ViewGroup parent){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_websites_item_string, parent, false);

        return v;
    }
}
