package com.example.uddishverma22.jugaadathonhack;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class NewBornRegister extends AppCompatActivity {

    EditText aadharNo, name, dob;
    Button submit;
    String UID = DoctorFirstActivity.UID;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference firebaseRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_born_register);

        aadharNo = (EditText) findViewById(R.id.aadhar_no);
        name = (EditText) findViewById(R.id.name);
        dob = (EditText) findViewById(R.id.dob);

        submit = (Button) findViewById(R.id.submit);

        aadharNo.setText(UID);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewBornPOJO newBornPOJO = new NewBornPOJO(name.getText().toString(), dob.getText().toString(), UID);

                Map<String,Object> taskMap = new HashMap<String,Object>();

                taskMap.put("child",newBornPOJO);

                firebaseRef.child("aadhars").child(DoctorFirstActivity.UID).updateChildren(taskMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isComplete()){
                            finish();
                            startActivity(new Intent(NewBornRegister.this,NewOrVaccine.class));
                        }
                    }
                });

            }
        });

    }
}
