package com.androidtime.mvp.interfaces;

import android.content.Context;

import java.util.HashMap;

public interface MainActivityView {
    void showIpInfo(HashMap hashMap);

    void startLoading();

    void stopLoading();

    void showMessage(String msg);

    Context getAppContext();
}
