package com.example.uddishverma22.jugaadathonhack;

import android.content.Intent;
import android.graphics.PointF;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import org.json.JSONObject;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;

/**
 * This activity shows the qr reader for the director
 */

public class DoctorFirstActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener {

    public static final String TAG = "Doctor";

    QRCodeReaderView mydecoderview;
    EditText uid;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference firebaseRef = database.getReference();
    JSONObject jsonObject;
    static String UID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_first);

        mydecoderview = (QRCodeReaderView) findViewById(R.id.doctorqr);
        uid = (EditText) findViewById(R.id.ed1);
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

        UID = uid.getText().toString();

        Log.d("tagg uid:", UID);

    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {

        convertXmlToJson(text);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mydecoderview.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mydecoderview.stopCamera();
    }

    public String convertXmlToJson(String xml) {
        XmlToJson xmlToJson = new XmlToJson.Builder(xml)
                .setAttributeName("/", "UID")
                .build();
        jsonObject = xmlToJson.toJson();
        Gson gson = new Gson();
        final BarcodeDataPOJO details = gson.fromJson(jsonObject.toString(), BarcodeDataPOJO.class);

        Log.d(TAG, "convertXmlToJson: UID " + details.getPrintLetterBarcodeData().getUID());
        Intent i = new Intent(this, NewOrVaccine.class);
        UID = String.valueOf(details.getPrintLetterBarcodeData().getUID());
        startActivity(i);

        return xmlToJson.toString();
    }
}
