package com.example.demo_gps_complex;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo_gps_complex.location.GPSLocationListener;
import com.example.demo_gps_complex.location.GPSLocationManager;


public class MainActivity extends AppCompatActivity implements GPSLocationListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GPSLocationManager gpsLocationManager = GPSLocationManager.getInstances(MainActivity.this);
        gpsLocationManager.start(MainActivity.this);
    }

    @Override
    public void UpdateLocation(Location location) {
        if (location != null) {
            Toast.makeText(MainActivity.this, location.getLongitude() +","+location.getLatitude(), Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void UpdateStatus(String provider, int status, Bundle extras) {
        Toast.makeText(MainActivity.this, "定位类型：" + provider, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void UpdateGPSProviderStatus(int gpsStatus) {
    }
}