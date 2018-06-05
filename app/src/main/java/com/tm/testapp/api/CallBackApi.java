package com.tm.testapp.api;

/**
 * Created by srikanth on 05/06/2018.
 */

public abstract class CallBackApi<T, K> {

    public abstract void onSuccess(T data);

    public abstract void onError(int httpCode, String errorCode, Object errorObject);

    public abstract void onFailure(K fail);

    public abstract void onExpired();

    public void onProcessError(int httpCode, String errorCode, Object errorObject) {
//        if (httpCode == 401) {
//            onExpired();
//        } else {
        onError(httpCode, errorCode, errorObject);
//        }
    }
}
