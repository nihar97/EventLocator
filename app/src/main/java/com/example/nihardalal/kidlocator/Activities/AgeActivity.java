package com.example.nihardalal.kidlocator.Activities;

import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.nihardalal.kidlocator.R;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        int[] resources = {R.id.check1, R.id.check2, R.id.check3, R.id.check4, R.id.check5, R.id.check6, R.id.check7, R.id.check8, R.id.check9, R.id.check10,
                R.id.check11, R.id.check12};
        for(int i= 0; i<resources.length;i++) {
            CheckBox temp = (CheckBox) findViewById(resources[i]);
            temp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        buttonView.setBackground(getResources().getDrawable(R.drawable.age_checked));
                        buttonView.setTextColor(getResources().getColor(R.color.hoop_yellow));
                        CheckBox allAges = (CheckBox) findViewById(R.id.all_ages);
                        allAges.setChecked(false);
                    } else {
                        buttonView.setBackground(getResources().getDrawable(R.drawable.age));
                        buttonView.setTextColor(getResources().getColor(R.color.white));
                    }
                }
            });
        }
        CheckBox allAges = (CheckBox) findViewById(R.id.all_ages);
        allAges.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    buttonView.setBackground(getResources().getDrawable(R.drawable.all_age_checked));
                    buttonView.setTextColor(getResources().getColor(R.color.hoop_yellow));
                    int[] resources = {R.id.check1, R.id.check2, R.id.check3, R.id.check4, R.id.check5, R.id.check6, R.id.check7, R.id.check8, R.id.check9, R.id.check10,
                            R.id.check11, R.id.check12};
                    for(int i= 0; i<resources.length;i++) {
                        CheckBox temp = (CheckBox) findViewById(resources[i]);
                        temp.setChecked(false);
                    }
                } else{
                    buttonView.setBackground(getResources().getDrawable(R.drawable.all_age));
                    buttonView.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

    }

//    public void ageOnClick(View v){
//        boolean checked = ((CheckBox) v).isChecked();
//        if(checked){
//            ((CheckBox) v).setBackground(getResources().getDrawable(R.drawable.age_checked));
//            ((CheckBox) v).setTextColor(getResources().getColor(R.color.hoop_yellow));
//            disableAllAges();
//        } else{
//            ((CheckBox) v).setBackground(getResources().getDrawable(R.drawable.age));
//            ((CheckBox) v).setTextColor(getResources().getColor(R.color.white));
//        }
//    }
//
//    public void allAgeOnClick(View v){
//        boolean checked = ((CheckBox) v).isChecked();
//        if(checked){
//            ((CheckBox) v).setBackground(getResources().getDrawable(R.drawable.all_age_checked));
//            ((CheckBox) v).setTextColor(getResources().getColor(R.color.hoop_yellow));
//            disableOtherAges();
//        } else{
//            ((CheckBox) v).setBackground(getResources().getDrawable(R.drawable.all_age));
//            ((CheckBox) v).setTextColor(getResources().getColor(R.color.white));
//        }
//    }
//
//    private void disableAllAges(){
//        CheckBox allAges = (CheckBox) findViewById(R.id.all_ages);
//        allAges.setChecked(false);
//    }
//
//    private void disableOtherAges(){
//        int[] resources = {R.id.check1, R.id.check2, R.id.check3, R.id.check4, R.id.check5, R.id.check6, R.id.check7, R.id.check8, R.id.check9, R.id.check10,
//        R.id.check11, R.id.check12};
//        for(int i= 0; i<resources.length;i++){
//            CheckBox temp = (CheckBox) findViewById(resources[i]);
//            temp.setChecked(false);
//            temp.performClick();
//        }
//    }
}

