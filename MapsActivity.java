package com.example.juanm.sanfranfood;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // COORD - SF: 37.76, -122.43
        try {
            ArrayList<Restaurant> restList = new Model().generateData();
            for(Restaurant rest : restList) {
                mMap = googleMap;
                LatLng coordinates = new LatLng(rest.getLat(), rest.getLng());
                mMap.addMarker(new MarkerOptions().position(coordinates).title(rest.getName()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(coordinates));
                // ON CLICK
                final String name = rest.getName();
                final String rating = rest.getRating();
                final String address = rest.getAddress();

                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        Intent intent = new Intent(MapsActivity.this, RestaurantActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("rating", rating);
                        intent.putExtra("address", address);
                        startActivity(intent);
                    }
                });

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
