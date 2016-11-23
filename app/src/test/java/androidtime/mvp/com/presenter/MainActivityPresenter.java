package androidtime.mvp.com.presenter;

import java.util.HashMap;

import androidtime.mvp.com.interfaces.MainActivityView;
import androidtime.mvp.com.interfaces.OnRequestComplete;
import androidtime.mvp.com.model.InvokeApi;

/**
 * Created by masum on 17/07/2016.
 */
public class MainActivityPresenter {
    MainActivityView view;
    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void getIpInformation() {
        view.startLoading();
        new InvokeApi(view.getAppContext(), new OnRequestComplete() {
            @Override
            public void onRequestComplete(Object infoData) {
                view.stopLoading();
                view.showIpInfo((HashMap) infoData);
            }
        });

    }


}
