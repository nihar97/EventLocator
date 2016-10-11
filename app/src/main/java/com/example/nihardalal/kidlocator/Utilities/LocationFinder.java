package com.example.nihardalal.kidlocator.Utilities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.example.nihardalal.kidlocator.Interfaces.CitySetter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Nihar Dalal on 7/29/2016.
 */
public class LocationFinder implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    public static final int MY_PERMISSIONS_ACCESS_FINE_LOCATION = 15;
    GoogleApiClient mGoogleApiClient;
    Context mContext;
    Location lastLocation;
    Activity mActivity;
    boolean permissionGranted = false;
    LocationRequest locationRequest = LocationRequest.create();
    CitySetter citySetter;

    public LocationFinder(Context c, Activity a, CitySetter citySetter) {
        mContext = c;
        mActivity = a;
        this.citySetter = citySetter;
        locationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);
        makeClient();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        } else {
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_ACCESS_FINE_LOCATION);
            if (permissionGranted) {
                lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            }
        }
        citySetter.setCity(getCity());
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("Connection Error:", connectionResult.getErrorMessage());
    }

    public void makeClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(mContext)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        connect();
    }

    public void connect() {
        mGoogleApiClient.connect();
    }

    public void disconnect() {
        mGoogleApiClient.disconnect();
    }

    public String getCity() {
        Geocoder geocoder = new Geocoder(mContext, Locale.US);
        try {
            if (lastLocation != null) {
                List<Address> adresses = geocoder.getFromLocation(lastLocation.getLatitude(), lastLocation.getLongitude(), 1);
                if (adresses.size() > 0) {
                    Address returnedAddress = adresses.get(0);
                    return returnedAddress.getLocality();
                }
            } else {
                startLocationUpdates();
                List<Address> adresses = geocoder.getFromLocation(lastLocation.getLatitude(), lastLocation.getLongitude(), 1);
                if (adresses.size() > 0) {
                    Address returnedAddress = adresses.get(0);
                    return returnedAddress.getLocality();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void onLocationChanged(Location location) {
        lastLocation = location;
    }

    public void startLocationUpdates() {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, this);
        } else {
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_ACCESS_FINE_LOCATION);
            if (true) {
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, this);
            }
        }
    }

    public GoogleApiClient getmGoogleApiClient() {
        return mGoogleApiClient;
    }

    public Context getmContext() {
        return mContext;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public Activity getmActivity() {
        return mActivity;
    }

    public boolean isPermissionGranted() {
        return permissionGranted;
    }

    public void setPermissionGranted(boolean permissionGranted) {
        this.permissionGranted = permissionGranted;
    }

    public LocationRequest getLocationRequest() {
        return locationRequest;
    }
}
