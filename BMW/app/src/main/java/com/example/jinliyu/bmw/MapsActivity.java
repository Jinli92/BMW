package com.example.jinliyu.bmw;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String latitude;
    String longitude;
    String id;
    String name;
    String address;
    String arrivaltime;


    TextView name_tv;
    TextView location_tv;
    TextView arrivalTime_tv;
    TextView coordiance_tv;

    Intent mainIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mainIntent=getIntent();
        latitude=mainIntent.getStringExtra("latitude");
        longitude=mainIntent.getStringExtra("longitude");

        location_tv=findViewById(R.id.location_tv);
        name_tv=findViewById(R.id.name_tv);
        arrivalTime_tv=findViewById(R.id.arrivateTime_tv);
        coordiance_tv=findViewById(R.id.coordiance);

        //get item information from MainActivity
        location_tv.setText("location: "+mainIntent.getStringExtra("address"));
        name_tv.setText("name: "+mainIntent.getStringExtra("name"));
        arrivalTime_tv.setText("arrival time: "+mainIntent.getStringExtra("arivalTime"));
        coordiance_tv.setText("latitude: "+latitude+"   longitude: "+longitude);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        // mark the latitude and longitude
        LatLng sydney = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
