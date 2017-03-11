package com.example.uddishverma22.jugaadathonhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Accessible by only doctors
 * The can update the vaccination details of a particular child
 */

public class ChildDetailsRegister extends AppCompatActivity {

    public static final String TAG = "checkbox";

    CheckBox bcg, dpt1, dpt2, dpt3, hbv1, hbv2, hbv3, measles, opv1, opv2, opv3;
    Button submit;
    String tempUID = "797764736939";

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference firebaseRef = database.getReference();
    VaccinePOJO vaccinePOJO;
    String myDate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_details_register);
//        final VaccinePOJO vaccinePOJO;

        bcg = (CheckBox) findViewById(R.id.bcg);
        dpt1 = (CheckBox) findViewById(R.id.dpt1);
        dpt2 = (CheckBox) findViewById(R.id.dpt2);
        dpt3 = (CheckBox) findViewById(R.id.dpt3);
        hbv1 = (CheckBox) findViewById(R.id.hbv1);
        hbv2 = (CheckBox) findViewById(R.id.hbv2);
        hbv3 = (CheckBox) findViewById(R.id.hbv3);
        opv1 = (CheckBox) findViewById(R.id.opv1);
        opv2 = (CheckBox) findViewById(R.id.opv2);
        opv3 = (CheckBox) findViewById(R.id.opv3);
        measles = (CheckBox) findViewById(R.id.measles);

        submit = (Button) findViewById(R.id.submit);


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy/MM/dd");
        myDate = simpleDateFormat.format(date);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vaccinePOJO = new VaccinePOJO(bcg.isChecked(), dpt1.isChecked(), dpt2.isChecked(), dpt3.isChecked(), hbv1.isChecked(),
                        hbv2.isChecked(), hbv3.isChecked(), opv1.isChecked(), opv2.isChecked(), opv3.isChecked(), measles.isChecked(), myDate);

                firebaseRef.child("aadhars").child(tempUID).child("Vaccines").setValue(vaccinePOJO);

            }
        });


    }
}
