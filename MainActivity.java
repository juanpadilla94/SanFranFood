package com.example.juanm.sanfranfood;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // group for both countries
    private RadioGroup radioGroup;
    // country button selected
    private RadioButton radioButton;
    // button that takes you to country activity based on selection
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup =(RadioGroup)findViewById(R.id.radioGroup);
        radioButton =(RadioButton)findViewById(R.id.radioButton);
        // button for next ports screen
        next =(Button)findViewById(R.id.button);
        // controller - user chooses option
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedID = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(selectedID);
                Intent intent;
                // check if a radio button is checked; otherwise wait till selection and then
                // user can select next
                if(radioButton != null) {
                    // user checked listings view for restaurants
                    if ("Listings View".equals(radioButton.getText())) {
                        intent = new Intent(MainActivity.this, ListingActivity.class);
                        startActivity(intent);
                    }
                    // user checked Map view for restaurants
                    else if ("Map View".equals(radioButton.getText())) {
                        intent = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
