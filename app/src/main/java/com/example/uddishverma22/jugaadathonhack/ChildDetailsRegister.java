package com.example.uddishverma22.jugaadathonhack;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Accessible by only doctors
 * The can update the vaccination details of a particular child
 */

public class ChildDetailsRegister extends AppCompatActivity {

    public static final String TAG = "checkbox";

    CheckBox bcg, dpt1, dpt2, dpt3, hbv1, hbv2, hbv3, measles, opv1, opv2, opv3;
    String sbcg= "null", sdpt1= "null", sdpt2= "null", sdpt3= "null",
            shbv1= "null", shbv2= "null", shbv3= "null", smeasles= "null", sopv1= "null", sopv2= "null", sopv3 = "null";
    Button submit;
    String tempUID = DoctorFirstActivity.UID;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference firebaseRef = database.getReference();
    VaccinePOJO vaccinePOJO;
    String myDate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_details_register);

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

                if (bcg.isChecked()) {
                    sbcg = myDate;
                }
                if (dpt1.isChecked()) {
                    sdpt1=myDate;

                }
                if (dpt2.isChecked()) {
                    sdpt2=myDate;

                }
                if (dpt3.isChecked()) {
                    sdpt3=myDate;

                }
                if (hbv1.isChecked()) {
                    shbv1=myDate;

                }
                if (hbv2.isChecked()) {
                    shbv1=myDate;

                }
                if (hbv3.isChecked()) {
                    shbv3=myDate;

                }
                if (opv1.isChecked()) {
                    sopv1=myDate;

                }
                if (opv2.isChecked()) {
                    sopv2=myDate;

                }
                if (opv3.isChecked()) {
                    sopv3=myDate;

                }
                if (measles.isChecked()) {
                    smeasles=myDate;
                }
                    vaccinePOJO = new VaccinePOJO(sbcg, sdpt1, sdpt2, sdpt3, shbv1,
                            shbv2, shbv3, sopv1, sopv2, sopv3, smeasles);

                Map<String,Object> taskMap = new HashMap<String,Object>();

                taskMap.put("Vaccines",vaccinePOJO);

                firebaseRef.child("aadhars").child(tempUID).child("child").updateChildren(taskMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isComplete()){
                            finish();
                            startActivity(new Intent(ChildDetailsRegister.this,NewOrVaccine.class));
                        }
                    }
                });

            }
        });


    }
}
