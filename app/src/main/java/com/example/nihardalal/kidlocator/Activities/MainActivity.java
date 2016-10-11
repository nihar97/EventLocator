package com.example.nihardalal.kidlocator.Activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.nihardalal.kidlocator.Fragments.GridFragment;
import com.example.nihardalal.kidlocator.Fragments.HorizontalFragment;
import com.example.nihardalal.kidlocator.Interfaces.CitySetter;
import com.example.nihardalal.kidlocator.R;
import com.example.nihardalal.kidlocator.Utilities.LocationFinder;
import com.example.nihardalal.kidlocator.Utilities.LocationFinderTest;
import com.google.android.gms.location.LocationServices;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class MainActivity extends AppCompatActivity implements CitySetter {

    int[] carouselImages = {R.drawable.harry_potter, R.drawable.harry_potter, R.drawable.harry_potter};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(carouselImages[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    getBaseContext().startActivity(intent);
                }
            });
        }
    };

    LocationFinderTest locationFinder;
    Toolbar toolbar;
    HorizontalFragment horizontalFragment = new HorizontalFragment();
    GridFragment gridFragment = new GridFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        CarouselView carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(carouselImages.length);

        carouselView.setImageListener(imageListener);

        replaceFragment(gridFragment,R.id.grid_fragment);
        replaceFragment(horizontalFragment, R.id.horizontal_fragment);
        locationFinder = new LocationFinderTest(this, this, this);
    }

    public void replaceFragment(Fragment frag, int resource){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if(frag.getClass() != horizontalFragment.getClass() && frag.getClass()!= gridFragment.getClass()){
                fragmentTransaction.remove(horizontalFragment);
                fragmentTransaction.remove(gridFragment);
            }
            fragmentTransaction.replace(resource, frag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case LocationFinder.MY_PERMISSIONS_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    locationFinder.setPermissionGranted(true);
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    locationFinder.setPermissionGranted(false);
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    private void stopLocationUpdates() {
        locationFinder.stopLocationUpdates();
    }

    public void setCity(String city){
        toolbar.setTitle(city);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (locationFinder.getmGoogleApiClient().isConnected()) {
            locationFinder.startLocationUpdates();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.filter:
                Intent filterIntent = new Intent(this,FilterActivity.class);
                startActivity(filterIntent);
                break;
        }
        return true;
    }

}
