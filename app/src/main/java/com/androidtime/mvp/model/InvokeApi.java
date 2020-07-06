package com.androidtime.mvp.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;

import com.androidtime.mvp.ConstantValues;
import com.androidtime.mvp.interfaces.OnRequestComplete;

public class InvokeApi {
    OnRequestComplete requestComplete;

    public InvokeApi(final Context context, final OnRequestComplete onRequestComplete) {
        this.requestComplete = onRequestComplete;

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ConstantValues.URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", "onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put("ip", jsonObject.getString("ip"));
                            hashMap.put("country", jsonObject.getString("country"));
                            hashMap.put("location", jsonObject.getString("loc"));
                            requestComplete.onRequestComplete(hashMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                requestComplete.onRequestError("Something went wrong." + error.getMessage());
                Log.e("Error", "onError: " + error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
