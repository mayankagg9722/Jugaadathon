package com.example.uddishverma22.jugaadathonhack;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, QRCodeReaderView.OnQRCodeReadListener {


    private TextView resultTextView;
    private QRCodeReaderView mydecoderview;
    public static final String TAG = "MainActivity";
    String dataString;
    JSONObject jsonObject;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference firebaseRef = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mydecoderview = (QRCodeReaderView) findViewById(R.id.qrdecoderview);
        resultTextView = (TextView) findViewById(R.id.tv1);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        resultTextView.setText(text);
        convertXmlToJson(text);

//        try {
//            jsonToObject();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        Intent i = new Intent(this, ChildDetailsRegister.class);
        i.putExtra("data", dataString);
        startActivity(i);

    }

    public void jsonToObject() throws FileNotFoundException {
        Gson gson = new Gson();
        BarcodeDataPOJO details = gson.fromJson(jsonObject.toString(), BarcodeDataPOJO.class);
        Log.d(TAG, "jsonToObject: DETAILS " + String.valueOf(details.getPrintLetterBarcodeData()));

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

//        ValueEventListener eventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot i:dataSnapshot.child("aadhars").getChildren()){
//                    Log.d(TAG, "onDataChange: key:"+i.getKey());
//                    if(!(i.getKey().equals(details.getPrintLetterBarcodeData().getUID()))){
//                                firebaseRef.child("aadhars").child(String.valueOf(details.getPrintLetterBarcodeData()
//                                        .getUID())).setValue(details.getPrintLetterBarcodeData());
//                        Log.d(TAG, "onDataChange: if CASE");
//                    }else {
//                        Toast.makeText(NavActivity.this, "USER ALREADY REGISTERED", Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, "onDataChange: ELSE CASE");
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        };
//
//        firebaseRef.addValueEventListener(eventListener);




        firebaseRef.child("aadhars").child(String.valueOf(details.getPrintLetterBarcodeData().getUID())).setValue(details.getPrintLetterBarcodeData());
//        Log.d(TAG, "jsonToObject: DETAILS " + String.valueOf(details.getPrintLetterBarcodeData().getUID()));
//        Log.d(TAG, "convertXmlToJson: JSON OBJECT " + jsonObject);
        return xmlToJson.toString();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


}
