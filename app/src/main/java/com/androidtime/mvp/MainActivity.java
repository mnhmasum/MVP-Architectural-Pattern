package com.androidtime.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import com.androidtime.mvp.interfaces.MainActivityView;
import com.androidtime.mvp.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private TextView textViewIp;
    private TextView textViewCountry;
    private TextView textViewLocation;
    private ProgressBar progressBar;

    MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);

        textViewIp = (TextView) findViewById(R.id.textViewIp);
        textViewCountry = (TextView) findViewById(R.id.textViewCountry);
        textViewLocation = (TextView) findViewById(R.id.textViewLocation);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getIpInformation();
            }
        });

    }

    @Override
    public void showIpInfo(HashMap hashMap) {
        textViewIp.setText("IP" + hashMap.get("ip").toString());
        textViewCountry.setText("Country" + hashMap.get("country").toString());
        textViewLocation.setText("Location" + hashMap.get("location").toString());
    }

    @Override
    public void startLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }
}
