package com.tm.testapp.storage;

import android.content.Context;

import com.tm.testapp.TestApplication;
import com.tm.testapp.model.TopWebsitesModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by srikanth on 05/06/2018.
 */

public class TmSampleStorage {

    private static final String TAG = TmSampleStorage.class.getSimpleName();
    private static TmSampleStorage objInstance;
    private Map storage;
    private Context context;
    private static final String KEY_TOP_WEBSITES_LIST = "KEY_TOP_WEBSITES_LIST";

    private TmSampleStorage() {
        context = TestApplication.getContext();
    }

    public static TmSampleStorage getObjInstance() {
        if (objInstance == null) {
            objInstance = new TmSampleStorage();
        }
        return objInstance;
    }

    public void setStorage(Map storage) {
        this.storage = storage;
    }

    /*
     * This storage is used to store publicKey,sessionKey and Nonce etc.
     */
    public Map getStorage() {
        if (storage == null) {
            storage = new HashMap();
        }
        return storage;
    }

    /**
     * Get Configuration Model.
     *
     * @return
     */
    public List<TopWebsitesModel> getTopWebsitesList() {
        return getStorage().containsKey(KEY_TOP_WEBSITES_LIST) ? (List<TopWebsitesModel>) getStorage().get(KEY_TOP_WEBSITES_LIST) : null;
    }

    /**
     * Set Configuration Model.
     *
     * @param List<TopWebsitesModel>
     */
    public void setTopWebsitesList(List<TopWebsitesModel> topWebsitesList) {
        getStorage().put(KEY_TOP_WEBSITES_LIST, topWebsitesList);
    }

}
