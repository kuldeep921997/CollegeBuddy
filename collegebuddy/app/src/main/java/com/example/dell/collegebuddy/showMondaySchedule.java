package com.example.dell.collegebuddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class showMondaySchedule extends AppCompatActivity {


    static DataBaseHelper mydb;
    static Context context;
    List<DatabaseModel> dbList;
    RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public Toolbar toolbarSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject_single_monday);
        context=showMondaySchedule.this;
        toolbarSchedule=(Toolbar)findViewById(R.id.toolbarSchedule);
        mydb = new DataBaseHelper(this);
        dbList = new ArrayList<DatabaseModel>();
        dbList = mydb.getAllData();
        mAdapter = new RecyclerAdapter(this, dbList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleviewmonday);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(showMondaySchedule.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mRecyclerView.setAdapter(mAdapter);
        registerForContextMenu(mRecyclerView);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(showMondaySchedule.this, schedule_monday.class);
                startActivity(i);
            }
        });

        initToolbar();
    }

    private void initToolbar(){
        setSupportActionBar(toolbarSchedule);
        getSupportActionBar().setTitle("Monday Schedules");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        mAdapter.getItemSelected(item,context);
        return super.onContextItemSelected(item);
    }

    public void deletefunction(String idhere) {
        boolean what = mydb.isEmptyMonday();
        if(what==true) {
            // mAdapter = new RecyclerAdapter(this, dbList);
            mydb.deleteDataMonday(idhere);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home :{
                onBackPressed();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent;
        super.onBackPressed();
        intent= new Intent(showMondaySchedule.this,week_activity.class);
        startActivity(intent);
        finish();
    }
}