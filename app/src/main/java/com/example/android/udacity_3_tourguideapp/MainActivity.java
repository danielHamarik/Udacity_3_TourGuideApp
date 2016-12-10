package com.example.android.udacity_3_tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    public static final String INTENT_DATA= "intentData";
    private ListArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        mAdapter = new ListArrayAdapter(this);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);

        initAdapter();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
        intent.putExtra(INTENT_DATA, mAdapter.getItem(position));
        startActivity(intent);
    }

    private void initAdapter(){
        mAdapter.add(new Destination(R.string.nyhavn_title, R.string.nyhavn_location, R.string.nyhavn_address, R.string.nyhavn_open, R.string.nyhavn_web, R.string.nyhavn_desc, R.string.nyhavn_history, R.drawable.nyhavn, R.string.nyhavn_lat, R.string.nyhavn_lon));
        mAdapter.add(new Destination(R.string.frederiksborg_title, R.string.frederiksborg_location, R.string.frederiksborg_address, R.string.frederiksborg_open, R.string.frederiksborg_web, R.string.frederiksborg_desc, R.string.frederiksborg_history, R.drawable.frederiksborg, R.string.frederiksborg_lat, R.string.frederiksborg_lon));
        mAdapter.add(new Destination(R.string.aros_title, R.string.aros_location, R.string.aros_address, R.string.aros_open, R.string.aros_web, R.string.aros_desc, R.string.aros_history, R.drawable.aros, R.string.aros_lat, R.string.aros_lon));
        mAdapter.add(new Destination(R.string.tivoli_title, R.string.tivoli_location, R.string.tivoli_address, R.string.tivoli_open, R.string.tivoli_web, R.string.tivoli_desc, R.string.tivoli_history, R.drawable.tivoli, R.string.tivoli_lat, R.string.tivoli_lon));
        mAdapter.add(new Destination(R.string.aquarium_title, R.string.aquarium_location, R.string.aquarium_address, R.string.aquarium_open, R.string.aquarium_web, R.string.aquarium_desc, R.string.aquarium_history, R.drawable.aquarium, R.string.aquarium_lat, R.string.aquarium_lon));
        mAdapter.add(new Destination(R.string.legoland_title, R.string.legoland_location, R.string.legoland_address, R.string.legoland_open, R.string.legoland_web, R.string.legoland_desc, R.string.legoland_history, R.drawable.legoland, R.string.legoland_lat, R.string.legoland_lon));
        mAdapter.add(new Destination(R.string.skagen_title, R.string.skagen_location, R.string.skagen_address, R.string.skagen_open, R.string.skagen_web, R.string.skagen_desc, R.string.skagen_history, R.drawable.skagen, R.string.skagen_lat, R.string.skagen_lon));
    }


}
