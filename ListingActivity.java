package com.example.juanm.sanfranfood;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        Model m = new Model();
        m.generateData();
        final ArrayList<Restaurant> restList = m.getRestList();
        // DYNAMICALLY ADDED VIEWS
        // layout for dynamically adde views
        LinearLayout layout = (LinearLayout)findViewById(R.id.lis_layout);
        for(int i = 0; i < restList.size(); i++) {
                final Button button = new Button(this);
                button.setId(i);
                // buttons
                button.setText(restList.get(i).getName());
                final String address;
                final String rating;

                address = restList.get(i).getAddress();
                rating = restList.get(i).getRating();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ListingActivity.this, RestaurantActivity.class);
                        intent.putExtra("address", address);
                        intent.putExtra("rating", rating);
                        startActivity(intent);
                    }
                });
                layout.addView(button);
        }
    }
}
