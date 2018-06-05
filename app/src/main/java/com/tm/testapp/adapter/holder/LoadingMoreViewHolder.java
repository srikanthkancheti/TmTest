package com.tm.testapp.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.tm.testapp.R;

/**
 * Created by srikanth on 05/06/2018.
 */

public class LoadingMoreViewHolder extends  RecyclerView.ViewHolder {

    public ProgressBar mProgressBar;

    public LoadingMoreViewHolder(View itemView) {
        super(itemView);
        mProgressBar= (ProgressBar) itemView.findViewById(R.id.progressBar);
    }
}
