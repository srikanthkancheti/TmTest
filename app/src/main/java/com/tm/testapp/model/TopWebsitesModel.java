package com.tm.testapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by srikanth on 05/06/2018.
 */

public class TopWebsitesModel implements Parcelable{

    String id_website;
    String total_visits;
    String visit_date;
    String website_name;

    protected TopWebsitesModel(Parcel in) {
        id_website = in.readString();
        total_visits = in.readString();
        visit_date = in.readString();
        website_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_website);
        dest.writeString(total_visits);
        dest.writeString(visit_date);
        dest.writeString(website_name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TopWebsitesModel> CREATOR = new Creator<TopWebsitesModel>() {
        @Override
        public TopWebsitesModel createFromParcel(Parcel in) {
            return new TopWebsitesModel(in);
        }

        @Override
        public TopWebsitesModel[] newArray(int size) {
            return new TopWebsitesModel[size];
        }
    };

    public String getIdWebsite() {
        return id_website;
    }

    public void setIdWebsite(String id_website) {
        this.id_website = id_website;
    }

    public String getTotalVisits() {
        return total_visits;
    }

    public void setTotalVisits(String total_visits) {
        this.total_visits = total_visits;
    }

    public String getVisitDate() {
        return visit_date;
    }

    public void setVisitDate(String visit_date) {
        this.visit_date = visit_date;
    }

    public String getWebsiteName() {
        return website_name;
    }

    public void setWebsiteName(String website_name) {
        this.website_name = website_name;
    }

}
