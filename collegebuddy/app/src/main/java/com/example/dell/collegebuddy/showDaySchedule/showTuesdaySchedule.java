package com.example.dell.collegebuddy.showDaySchedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.example.dell.collegebuddy.DataBaseHelper;
import com.example.dell.collegebuddy.DatabaseModelTuesday;
import com.example.dell.collegebuddy.R;
import com.example.dell.collegebuddy.RecyclerAdapterTuesday;
import com.example.dell.collegebuddy.scheduleDays.schedule_tuesday;
import com.example.dell.collegebuddy.week_activity;
import java.util.ArrayList;
import java.util.List;


public class showTuesdaySchedule extends AppCompatActivity {


    static DataBaseHelper mydb;
    static Context context;
    public Toolbar toolbarSchedule;
    List<DatabaseModelTuesday> dbList;
    RecyclerView mRecyclerView;
    private RecyclerAdapterTuesday mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject_single_monday);

        context=showTuesdaySchedule.this;
        toolbarSchedule=(Toolbar)findViewById(R.id.toolbarSchedule);
        mydb = new DataBaseHelper(this);
        dbList = new ArrayList<DatabaseModelTuesday>();
        dbList = mydb.getAllDataTuesday();

        mAdapter = new RecyclerAdapterTuesday(this, dbList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleviewmonday);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(showTuesdaySchedule.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        registerForContextMenu(mRecyclerView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(showTuesdaySchedule.this, schedule_tuesday.class);
                startActivity(i);
            }
        });
        initToolbar();
    }

    private void initToolbar(){
        setSupportActionBar(toolbarSchedule);
        getSupportActionBar().setTitle("Tuesday Schedules");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        mAdapter.getItemSelected(item,context);
        return super.onContextItemSelected(item);
    }

    public void deletefunction(String idhere) {
        boolean what = mydb.isEmptyTuesday();
        if (what == true) {
            mydb.deleteDataTuesday(idhere);

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
        intent= new Intent(showTuesdaySchedule.this,week_activity.class);
        startActivity(intent);
        finish();
    }
}