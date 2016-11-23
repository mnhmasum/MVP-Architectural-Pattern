package androidtime.mvp.com.interfaces;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by masum on 17/07/2016.
 */
public interface MainActivityView {
    void showIpInfo(HashMap hashMap);
    void startLoading();
    void stopLoading();
    Context getAppContext();
}
