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
import com.example.dell.collegebuddy.DatabaseModelWednesday;
import com.example.dell.collegebuddy.R;
import com.example.dell.collegebuddy.RecyclerAdapterWednesday;
import com.example.dell.collegebuddy.scheduleDays.schedule_wednesday;
import com.example.dell.collegebuddy.week_activity;
import java.util.ArrayList;
import java.util.List;


public class showWednesdaySchedule extends AppCompatActivity {

    static DataBaseHelper mydb;
    static Context context;
    public Toolbar toolbarSchedule;
    List<DatabaseModelWednesday> dbList;
    RecyclerView mRecyclerView;
    private RecyclerAdapterWednesday mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject_single_monday);

        context=showWednesdaySchedule.this;
        toolbarSchedule=(Toolbar)findViewById(R.id.toolbarSchedule);
        mydb = new DataBaseHelper(this);
        dbList = new ArrayList<DatabaseModelWednesday>();
        dbList = mydb.getAllDataWednesday();

        mAdapter = new RecyclerAdapterWednesday(this, dbList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleviewmonday);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(showWednesdaySchedule.this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mRecyclerView.setAdapter(mAdapter);
        registerForContextMenu(mRecyclerView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(showWednesdaySchedule.this, schedule_wednesday.class);
                startActivity(i);
            }
        });
        initToolbar();
    }

    private void initToolbar(){
        setSupportActionBar(toolbarSchedule);
        getSupportActionBar().setTitle("Wednesday Schedules");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        mAdapter.getItemSelected(item,context);
        return super.onContextItemSelected(item);
    }

    public void deletefunction(String idhere) {
        boolean what = mydb.isEmptyWednesday();
        if (what == true) {
            mydb.deleteDataWednesday(idhere);

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
        intent= new Intent(showWednesdaySchedule.this,week_activity.class);
        startActivity(intent);
        finish();
    }
}