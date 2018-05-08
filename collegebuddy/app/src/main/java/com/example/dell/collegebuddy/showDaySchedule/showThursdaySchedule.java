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
import com.example.dell.collegebuddy.DatabaseModelThursday;
import com.example.dell.collegebuddy.R;
import com.example.dell.collegebuddy.RecyclerAdapterThursday;
import com.example.dell.collegebuddy.scheduleDays.schedule_thursday;
import com.example.dell.collegebuddy.showMondaySchedule;
import com.example.dell.collegebuddy.week_activity;

import java.util.ArrayList;
import java.util.List;


public class showThursdaySchedule extends AppCompatActivity {

    static DataBaseHelper mydb;
    static Context context;
    public Toolbar toolbarSchedule;
    List<DatabaseModelThursday> dbList;
    RecyclerView mRecyclerView;
    private RecyclerAdapterThursday mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject_single_monday);

        context=showThursdaySchedule.this;
        toolbarSchedule=(Toolbar)findViewById(R.id.toolbarSchedule);
        mydb = new DataBaseHelper(this);
        dbList = new ArrayList<DatabaseModelThursday>();
        dbList = mydb.getAllDataThursday();

        mAdapter = new RecyclerAdapterThursday(this, dbList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleviewmonday);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(showThursdaySchedule.this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mRecyclerView.setAdapter(mAdapter);
        registerForContextMenu(mRecyclerView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(showThursdaySchedule.this, schedule_thursday.class);
                startActivity(i);
            }
        });
        initToolbar();
    }

    private void initToolbar(){
        setSupportActionBar(toolbarSchedule);
        getSupportActionBar().setTitle("Thursday Schedules");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        mAdapter.getItemSelected(item,context);
        return super.onContextItemSelected(item);
    }

    public void deletefunction(String idhere) {
        boolean what = mydb.isEmptyThursday();
        if (what == true) {
            mydb.deleteDataThursday(idhere);

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
        intent= new Intent(showThursdaySchedule.this,week_activity.class);
        startActivity(intent);
        finish();
    }
}