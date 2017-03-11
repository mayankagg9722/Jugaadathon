package com.example.uddishverma22.jugaadathonhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        details = (TextView) findViewById(R.id.details_json);
        Intent i = getIntent();
        String data = i.getStringExtra("data");
        details.setText(data);

    }
}
