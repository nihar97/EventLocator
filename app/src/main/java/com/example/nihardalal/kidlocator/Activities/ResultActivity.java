package com.example.nihardalal.kidlocator.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nihardalal.kidlocator.R;

public class ResultActivity extends AppCompatActivity {
    ImageView itemImage, mapImage;
    TextView title, subtitle, date, description,phone, website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        itemImage = (ImageView) findViewById(R.id.imageView);
        itemImage.setImageResource(R.drawable.harry_potter);

        title = (TextView)findViewById(R.id.title);
        title.setText(R.string.harry_potter_title);
        subtitle = (TextView) findViewById(R.id.subtitle);
        subtitle.setText(R.string.harry_potter_subtitle);
        date = (TextView) findViewById(R.id.date);
        date.setText(R.string.harry_potter_date);
        description = (TextView) findViewById(R.id.description);
        description.setText(R.string.harry_potter_desc);
        phone = (TextView) findViewById(R.id.call);
        phone.setText(R.string.harry_potter_phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phone.getText()));
                if (callIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(callIntent);
                }
            }
        });
        mapImage = (ImageView) findViewById(R.id.map);
        mapImage.setImageResource(R.drawable.map);
        website = (TextView) findViewById(R.id.view_website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage =Uri.parse("http://www.harrypottertheplay.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(title.getText());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return true ;
    }
}
