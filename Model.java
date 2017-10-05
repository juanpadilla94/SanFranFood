package com.example.juanm.sanfranfood;


import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Created by JuanM on 10/4/2017.
 */

public class Model {

    public ArrayList<Restaurant> generateData() throws IOException {
        // list of all restaurants near area
        ArrayList<Restaurant> restList = new ArrayList<Restaurant>();
        try {
            String url = "https://maps.googleapis.com" +
                    "/maps/api/place/nearbysearch/json?" +
                    "location=37.76,-122.43&radius=500&" +
                    "type=restaurant&keyword=&key=AIzaSyB-bpw0ollWA5AKpT11Y2CL2qPFs4kC_dk";
            JSONObject reader = readJsonFromUrl(url);
            JSONArray results = reader.getJSONArray("results");
            for ( int i = 0; i < results.length() ; i++) {
                JSONObject result = results.getJSONObject(i);
                Restaurant rest = new Restaurant(result.getString("id"), result.getString("name"));
                // get/set coordinates
                JSONObject location = result.getJSONObject("geometry").getJSONObject("location");
                double lat = location.getDouble("lat");
                double lng = location.getDouble("lng");
                rest.setCoord(lat, lng);
                restList.add(rest);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return restList;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
