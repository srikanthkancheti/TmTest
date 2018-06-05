package com.tm.testapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by srikanth on 05/06/2018.
 */

public class DateTimeUtils {

    public static final String SERVER_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZZZZZ"; //2013-04-24T22:53:03+00:00
    public static final String SERVER_DATE_TIME_PATTERN_2 = "yyyy-MM-dd'T'HH:mm:ss"; //2017-11-28T10:39:37

    public static final String LAST_UPDATE_DATE_TIME_PATTERN = "HH:mm, EEEE - MM/dd/yyyy"; // 14:24, Today - 09/21/2015

    public static final String SIMPLE_DATE_TIME_PATTERN = "MMM dd, yyyy - hh:mm aa"; // Oct 19, 2015 - 01:00 AM

    public static final String LONG_LETTER_DATE_FORMAT = "dd MMM yyyy, hh:mm"; // 14 December 2015, 09:00

    public static final String SIMPLE_DATE_PATTERN = "MM-dd-yyyy";
    public static final String DOB_DATE_PATTERN = "yyyy-MM-dd";

    public static final String DATE_MONTH_FULL_PATTERN = "dd MMMM yyyy";
    public static final String DATE_TIME_LOGIN_PATTERN = "hh:mm - dd MMMM yyyy";

    public static final String BIRTH_DATE_PATTERN = "dd/MM/yyyy";
    public static final String SCHEDULED_TIME_PATTERN = "MMM dd, yyyy, hh:mm";

    public static final String MONTH_DAY_YEAR_PATTERN = "MMM dd, yyyy";

    public static final String MMM_DD_YYYY_PATTERN = "MMM dd, yyyy";
    public static final String DD_MMMM_YYYY_PATTERN = "dd MMMM, yyyy";
    public static final String DD_MM_YYYY_PATTERN = "dd/ MM/ yyyy";
    public static final String DD_MMM_YYYY_PATTERN = "dd MMM yyyy";
    public static final String DD_MM_PATTERN = "dd/MM";

    public static final String QR_CODE_DATE_TIME_PATTERN = "MMM dd, yyyy,hh:mm aa";

    public static final String TIME_12_PATTERN = "hh:mm aa";
    public static final String TIME_24_PATTERN = "hh:mm";

    public static final String DATE_MONTH_DATE_PATTERN = "MMM dd";
    public static final String MONTH_YEAR_PATTERN = "MMM yyyy";
    public static final String DAY_MONTH_YEAR_FORMAT = "dd - MM - yyyy";
    public static final String DAY_TIME_REPORT_FORMAT = "hh:mm - MMM yy";
    public static final String DAY_TIME_REPORT_FORMAT_VBIR = "hh:mm - MMM dd";


    public static String convertServerTime(String dateTime, String convertPattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(SERVER_DATE_TIME_PATTERN, java.util.Locale.getDefault());
        try {
            Date date = sdf.parse(dateTime);
            return convertServerTime(date, convertPattern);
        } catch (ParseException e) {
            return "";
        }
    }

    public static String convertDobDate(String dateTime, String convertPattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(DD_MMM_YYYY_PATTERN, java.util.Locale.getDefault());
        try {
            Date date = sdf.parse(dateTime);
            return convertServerTime(date, convertPattern);
        } catch (ParseException e) {
            return "";
        }
    }

    public static String convertServerTime2(String dateTime, String convertPattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(SERVER_DATE_TIME_PATTERN_2, java.util.Locale.getDefault());
        try {
            Date date = sdf.parse(dateTime);
            return convertServerTime(date, convertPattern);
        } catch (ParseException e) {
            return "";
        }
    }

    public static Calendar getCalendarFromString(String dateTime) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(SERVER_DATE_TIME_PATTERN, Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(dateTime));// all done
            return cal;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String convertServerTime(Date dateTime, String convertPattern) {
        SimpleDateFormat sdf2 = new SimpleDateFormat(convertPattern, java.util.Locale.getDefault());
        return sdf2.format(dateTime);
    }

    public static Date getDateFromString(String dateTime, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, java.util.Locale.getDefault());
        try {
            return sdf.parse(dateTime);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static String getCurrentTimeString() {
        SimpleDateFormat sdf = new SimpleDateFormat(SERVER_DATE_TIME_PATTERN, java.util.Locale.getDefault());
        Date date = new Date();
        return sdf.format(date);
    }

    public static String getCurrentTimeString(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, java.util.Locale.getDefault());
        Date date = new Date();
        return sdf.format(date);
    }

    public static String getStringDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, java.util.Locale.getDefault());
        return sdf.format(date);
    }

    /**
     * Thong Nguyen
     *
     * @param date
     * @return 0: today, 1 : > today , -1 : yesterday, -2 : < yesterday
     */
    public static int isToday(Date date) {
        Calendar calendar = Calendar.getInstance();//today
        Calendar checkDate = Calendar.getInstance();
        checkDate.setTime(date);
        if (calendar.get(Calendar.YEAR) == checkDate.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == checkDate.get(Calendar.DAY_OF_YEAR)) {
            return 0;//today
        } else {
            calendar.add(Calendar.DAY_OF_YEAR, -1);//yesterday
            if (calendar.get(Calendar.YEAR) == checkDate.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == checkDate.get(Calendar.DAY_OF_YEAR)) {
                return -1;//yesterday
            } else {
                if (calendar.getTime().getTime() > checkDate.getTime().getTime()) {
                    return -2;// past day
                } else {
                    return 1;//future day
                }
            }
        }
    }

    public static Date getDateFromString(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat(SERVER_DATE_TIME_PATTERN, java.util.Locale.getDefault());
        try {
            return sdf.parse(dateTime);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static String getMessageDateTime(Date date) {
        if (isToday(date) == 0) {
            return DateTimeUtils.convertServerTime(date, DateTimeUtils.TIME_12_PATTERN);
        } else {
            return DateTimeUtils.convertServerTime(date, DateTimeUtils.DATE_MONTH_DATE_PATTERN);
        }
    }

    public static String getMessageCountDown(int second) {
        int hour = second / 3600;
        int minute = (second - hour * 3600) / 60;
        String minStr = "";
        String hourStr = "";
        if (hour < 10) {
            hourStr = "0" + hour;
        } else {
            hourStr = "" + hour;
        }
        if (minute < 10) {
            minStr = "0" + minute;
        } else {
            minStr = "" + minute;
        }
        int sec = second % 60;
        if (sec < 10) {
            return hourStr + ":" + minStr + ":0" + sec;
        } else {
            return hourStr + ":" + minStr + ":" + sec;
        }

    }

    private static String twoDigitString(int number) {
        if (number / 10 == 0) {
            return "" + number;
        }
        return String.valueOf(number);
    }
}
