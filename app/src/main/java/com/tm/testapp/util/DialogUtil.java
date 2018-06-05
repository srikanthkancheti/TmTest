package com.tm.testapp.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.calendardatepicker.MonthAdapter;

import java.util.Calendar;
import java.util.List;

/**
 * Created by srikanth on 05/06/2018.
 */

public class DialogUtil {

    public interface SinglePickerCallback {
        void onSelectSingle(Dialog dialog, View view, int position, Object data);
    }

    public interface CalendarPickerCallback {
        void onSelectDate(DialogFragment dialog, int year, int monthOfYear, int dayOfMonth);
    }

    public interface CountryPickerCallback {
        void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID);
    }

    public static Dialog showSinglePicker(Context context, int resourceTitle, int resourceArray, int resourceTitleButton, final SinglePickerCallback callback) {
        return new MaterialDialog.Builder(context)
                .title(resourceTitle)
                .items(resourceArray)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        callback.onSelectSingle(dialog, view, which, text);
                        return true;
                    }
                })
                .positiveText(resourceTitleButton)
                .show();
    }

    public static Dialog showAlertTouchIdDialog(Context context, int layout, String cancelResource, MaterialDialog.SingleButtonCallback callbackCancel) {
        return new MaterialDialog.Builder(context)
                .customView(layout, false)
                .negativeText(cancelResource)
                .onNegative(callbackCancel)
                .show();
    }


    public static Dialog showConfirmDialog(Context context, String messageResource, String cancelResource, String agreeResource, MaterialDialog.SingleButtonCallback callbackOk, MaterialDialog.SingleButtonCallback callbackCancel) {
        return new MaterialDialog.Builder(context)
                .content(messageResource)
                .positiveText(agreeResource)
                .negativeText(cancelResource)
                .onPositive(callbackOk)
                .onNegative(callbackCancel)
                .show();
    }

    public static Dialog showNotificationDialog(Context context, String title, String messageResource, String cancelResource, String agreeResource, MaterialDialog.SingleButtonCallback callbackOk, MaterialDialog.SingleButtonCallback callbackCancel, DialogInterface.OnCancelListener cancelListener) {
        return new MaterialDialog.Builder(context)
                .title(title)
                .canceledOnTouchOutside(true)
                .cancelListener(cancelListener)
                .content(messageResource)
                .positiveText(agreeResource)
                .negativeText(cancelResource)
                .onPositive(callbackOk)
                .onNegative(callbackCancel)
                .show();
    }

    public static Dialog showErrorDialog(Context context, String messageResource, String cancelResource, MaterialDialog.SingleButtonCallback callbackCancel) {
        return new MaterialDialog.Builder(context)
                .content(messageResource)
                .negativeText(cancelResource)
                .onNegative(callbackCancel)
                .show();
    }

    public static void showDatePicker(FragmentManager supportFragmentManager, String doneText, String cancelText, final CalendarPickerCallback callback) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                .setOnDateSetListener(new CalendarDatePickerDialogFragment.OnDateSetListener() {
                    @Override
                    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
                        callback.onSelectDate(dialog, year, monthOfYear, dayOfMonth);
                    }
                })
                .setDoneText(doneText)
                .setPreselectedDate(year, month, day)
                .setCancelText(cancelText);

        MonthAdapter.CalendarDay minCalendarDay = new MonthAdapter.CalendarDay();
        minCalendarDay.setDay(1900, 0, 1);

        MonthAdapter.CalendarDay maxCalendarDay = new MonthAdapter.CalendarDay();
        maxCalendarDay.setDay(year, month, day);
        cdp.setDateRange(minCalendarDay, maxCalendarDay);
        cdp.show(supportFragmentManager, "FRAG_TAG_DATE_PICKER");
    }

}
