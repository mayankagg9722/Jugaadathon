package com.example.uddishverma22.jugaadathonhack;

import android.content.Intent;
import android.graphics.PointF;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

public class DoctorFirstActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener{


     QRCodeReaderView mydecoderview;
     EditText uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_first);

        mydecoderview = (QRCodeReaderView) findViewById(R.id.doctorqr);
        uid=(EditText)findViewById(R.id.ed1);

        String UID=uid.getText().toString();

        Log.d("tagg uid:", UID);

    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        Log.d("tagg",text);
    }
}
