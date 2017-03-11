package com.example.uddishverma22.jugaadathonhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * This activity shows the page where the doctor can register new born babies or add existing information
 */

public class NewOrVaccine extends AppCompatActivity {

    TextView newBorn, vaccinate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_or_vaccine);

        newBorn = (TextView) findViewById(R.id.new_born);
        vaccinate = (TextView) findViewById(R.id.vaccinate);

        newBorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewBornRegister.class);
                startActivity(i);
            }
        });

        vaccinate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ChildDetailsRegister.class);
                startActivity(i);
            }
        });
    }
}
