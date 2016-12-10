package com.example.android.udacity_3_tourguideapp;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedActivity extends AppCompatActivity implements View.OnClickListener {

    private Destination dest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        dest = getIntent().getParcelableExtra(MainActivity.INTENT_DATA);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(dest.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView image = (ImageView) findViewById(R.id.appbar_image);
        image.setImageResource(dest.getImageSrc());

        TextView address = (TextView) findViewById(R.id.detail_address);
        address.setText(dest.getAddress());
        TextView open = (TextView) findViewById(R.id.detail_open);
        open.setText(dest.getOpen());
        TextView web = (TextView) findViewById(R.id.detail_web);
        web.setText(dest.getWeb());
        web.setOnClickListener(this);

        TextView description = (TextView) findViewById(R.id.detail_desc);
        description.setText(dest.getDescription());
        TextView history = (TextView) findViewById(R.id.detail_history);
        history.setText(dest.getHistory());

        FloatingActionButton mFab = (FloatingActionButton) findViewById(R.id.detail_fab);
        mFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.detail_fab){
            String lat = getResources().getString(dest.getLat());
            String lon = getResources().getString(dest.getLon());
            String title = getResources().getString(dest.getTitle());
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<lat>,<long>?q=<"+lat+">,<"+lon+">("+title+")"));
            startActivity(intent);
        }else if(v.getId() == R.id.detail_web){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(getResources().getString(dest.getWeb())));
            startActivity(i);
        }
    }
}
