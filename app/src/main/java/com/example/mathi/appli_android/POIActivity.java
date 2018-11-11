package com.example.mathi.appli_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;


public class POIActivity extends AppCompatActivity {

    static final String TAG = "Centrale";
    public ArrayList<POI> pointofinterest = new ArrayList<POI>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi);

        ImageView mImageView;
        final TextView  mTxtDisplay = (TextView) findViewById(R.id.txtDisplay);
        String url = "http://voyage2.corellis.eu/api/v2/homev2?lat=43.14554197717751&lon=6.00.246207789145&offset=0";
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest (Request.Method.GET, url,new Response.Listener() {

            @Override
            public void onResponse(Object o) {
// Display the first 500 characters of the response string.
                String response = (String)o;
                Log.d(TAG, "onResponse");
                mTxtDisplay.setText("Response is: "+ response.substring(0,500));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse");
                mTxtDisplay.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

            }
