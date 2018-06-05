package com.tm.testapp.adapter;

import android.support.v7.widget.RecyclerView;

/**
 * Created by srikanth on 05/06/2018.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter {

    public static final int TYPE_ITEM = 1;
    public static final int TYPE_FOOTER = 2;
    public static final int TYPE_HEADER = 3;
    public static final String TAG_ITEM_CLICK="TAG_ITEM_CLICK";
    boolean isStillLoadingMore = false;
    boolean isHasFooter=true;
    boolean isHasHeader=false;
//    RecyclerItemOnClick mItemOnClick;
//    FavoriteClickListener mFavoriteOnClick;

    public boolean isStillLoadingMore() {
        return isStillLoadingMore;
    }

    public void setStillLoadingMore(boolean stillLoadingMore) {
        isStillLoadingMore = stillLoadingMore;
    }

    public boolean isHasHeader() {
        return isHasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        isHasHeader = hasHeader;
    }

    public boolean isHasFooter() {
        return isHasFooter;
    }

    public void setHasFooter(boolean hasFooter) {
        isHasFooter = hasFooter;
    }

//    public RecyclerItemOnClick getItemOnClick() {
//        return mItemOnClick;
//    }
//
//    public BaseAdapter setItemOnClick(RecyclerItemOnClick itemOnClick) {
//        mItemOnClick = itemOnClick;
//        return this;
//    }
//
//    public BaseAdapter setOnFavoriteClick(FavoriteClickListener favoriteClick) {
//        mFavoriteOnClick = favoriteClick;
//        return this;
//    }

    public BaseAdapter() {
    }
}
