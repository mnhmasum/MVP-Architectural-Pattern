package com.androidtime.mvp.interfaces;

public interface OnRequestComplete {
    void onRequestComplete(Object o);
    void onRequestError(String errorMsg);
}
