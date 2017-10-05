package com.example.juanm.sanfranfood;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        // address
        TextView resAddressText = (TextView) findViewById(R.id.res_address_text);
        resAddressText.setText(getIntent().getStringExtra("address"));
        resAddressText.setTextColor(Color.parseColor("#ffffff"));
        resAddressText.setBackgroundColor(Color.parseColor("#f08500"));
        // rating
        TextView resRatingText = (TextView) findViewById(R.id.res_rating_text);
        resRatingText.setText("rating: " + getIntent().getStringExtra("rating"));
        resRatingText.setTextColor(Color.parseColor("#ffffff"));
        resRatingText.setBackgroundColor(Color.parseColor("#4272b7"));
    }
}
