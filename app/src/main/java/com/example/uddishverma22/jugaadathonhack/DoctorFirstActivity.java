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
        uid = (EditText)findViewById(R.id.ed1);
        mydecoderview.setOnQRCodeReadListener(this);

        // Use this function to enable/disable decoding
        mydecoderview.setQRDecodingEnabled(true);

        // Use this function to change the autofocus interval (default is 5 secs)
        mydecoderview.setAutofocusInterval(2000L);

        // Use this function to enable/disable Torch
        mydecoderview.setTorchEnabled(true);

        // Use this function to set front camera preview
        mydecoderview.setFrontCamera();

        // Use this function to set back camera preview
        mydecoderview.setBackCamera();

        String UID = uid.getText().toString();

        Log.d("tagg uid:", UID);

    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        Log.d("tagg",text);
    }
}
