package com.example.mathi.appli_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class POIActivity extends AppCompatActivity {

    static final String TAG = "Centrale";


    ListView results;
    String JsonURL = "http://voyage2.corellis.eu/api/v2/homev2?lat=43.14554197717751&lon=6.00246207789145&offset=0";
    String data = "";
    RequestQueue requestQueue;
    List<POI> biblio = new ArrayList<POI>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi);
        requestQueue = Volley.newRequestQueue(this);
        results = (ListView) findViewById(R.id.listview);
        JSONObject jsonObj = new JSONObject();


        JsonObjectRequest arrayobj = new JsonObjectRequest(JsonURL, jsonObj,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray tab = response.getJSONArray("data");
                            for (int i = 0; i < tab.length(); i++) {
                                //gets each JSON object within the JSON array
                                JSONObject jsonObject = tab.getJSONObject(i);

                                // Retrieves the string labeled "colorName" and "hexValue",
                                // and converts them into javascript objects
                                String type = !jsonObject.isNull("type") ? jsonObject.getString("type") : "";

                                if (type.equals("RESTAURANT") || type.equals("POI") || type.equals("CITY") || type.equals("GOELOC")) {
                                    Log.d("TEST1", Integer.toString(i));
                                    String display = !jsonObject.isNull("display") ? jsonObject.getString("display") : "";
                                    String media = !jsonObject.isNull("media") ? jsonObject.getString("media") : "";

                                    if (!jsonObject.isNull("location")) {
                                        JSONObject loc = jsonObject.getJSONObject("location");
                                        JSONObject coords = loc.getJSONObject("coordonnées");
                                        Double lat = Double.parseDouble(coords.getString("lat"));
                                        Double longi = Double.parseDouble(coords.getString("lon"));
                                    } else {
                                        double lat = 0;
                                        double longi = 0;
                                    }

                                    Double lat = !jsonObject.isNull("lat") ? Double.parseDouble(jsonObject.getString("lat")) : 0;
                                    Double longi = !jsonObject.isNull("lon") ? Double.parseDouble(jsonObject.getString("lon")) : 0;

                                    POI POI = new POI(type, display, media, lat, longi);

                                    Log.d("lat", Double.toString(lat));
                                    Log.d("long", Double.toString(longi));
                                    biblio.add(POI);
                                }
                            }
                            POIAdapter adapter = new POIAdapter(getApplicationContext(), biblio);
                            results.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                        catch (JSONException e) {

                            Log.d("TEST :", "Exception" + e.toString());
                            e.printStackTrace();

                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        requestQueue.add(arrayobj);
    }

            }
