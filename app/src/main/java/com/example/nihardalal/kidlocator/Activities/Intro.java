package com.example.nihardalal.kidlocator.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.example.nihardalal.kidlocator.Fragments.FirstSlide;
import com.example.nihardalal.kidlocator.Fragments.SecondSlide;
import com.example.nihardalal.kidlocator.Fragments.ThirdSlide;

public class Intro extends com.github.paolorotolo.appintro.AppIntro {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(new FirstSlide());
        addSlide(new SecondSlide());
        addSlide(new ThirdSlide());

        showSkipButton(true);
        showStatusBar(true);
    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        loadMainActivity();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        loadMainActivity();
    }


    public void getStarted(View v){
        loadMainActivity();
    }
}

