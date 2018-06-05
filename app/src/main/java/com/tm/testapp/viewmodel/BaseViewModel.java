package com.tm.testapp.viewmodel;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/**
 * Created by srikanth on 05/06/2018.
 */

public class BaseViewModel {

//    public void showProgress(LifeCycle.View viewCallBack) {
//        if (progressDialog == null && viewCallBack != null) {
//            progressDialog = new Dialog(viewCallBack.getActivity());
//            progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            LayoutInflater inflater = viewCallBack.getActivity().getLayoutInflater();
//            View layout = inflater.inflate(R.layout.view_progress_dialog, null);
//            SimpleDraweeView imageView = layout.findViewById(R.id.ivProgressDialog);
//            imageView.setController(controller);
//            progressDialog.setContentView(layout);
//            progressDialog.setCanceledOnTouchOutside(false);
//            progressDialog.show();
//        } else if (progressDialog != null && viewCallBack != null) {
//            progressDialog.show();
//        }
//    }
//
//    public void hideProgress() {
//        if (progressDialog != null) {
//            progressDialog.cancel();
//            progressDialog = null;
//        }
//    }
//
//    public boolean isProgressShowing() {
//        if (progressDialog != null)
//            return progressDialog.isShowing();
//        else
//            return false;
//    }
}
