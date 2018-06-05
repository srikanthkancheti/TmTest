package com.tm.testapp.util;

import android.app.Activity;
import android.content.Intent;

import com.tm.testapp.activity.MainActivity;

/**
 * Created by srikanth on 05/06/2018.
 */

public class ActivityHelper {

    public static void openMainScreen(Activity context) {
        Intent it = new Intent(context, MainActivity.class);
        context.startActivity(it);
    }
}
