package com.example.dell.collegebuddy.scheduleDays;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.example.dell.collegebuddy.DataBaseHelper;
import com.example.dell.collegebuddy.DatabaseModelFriday;
import com.example.dell.collegebuddy.DatabaseModelWednesday;
import com.example.dell.collegebuddy.R;
import com.example.dell.collegebuddy.RecyclerAdapterFriday;
import com.example.dell.collegebuddy.RecyclerAdapterWednesday;
import com.example.dell.collegebuddy.showDaySchedule.showWednesdaySchedule;
import com.example.dell.collegebuddy.week_activity;
import com.example.dell.collegebuddy.showDaySchedule.showFridaySchedule;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class schedule_friday extends AppCompatActivity implements View.OnClickListener {

    DataBaseHelper mydb;
    public EditText sttime;
    public EditText edtime;
    public EditText subname;
    public TextView tvdisplay;
    public Button btnsubmit;
    public Button viewallbtn;
    RecyclerAdapterFriday mAdeptar;
    showFridaySchedule showFridaySchedule;
    List<DatabaseModelFriday> dbList;
    RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public Calendar mCalendar;
    private int mHour,mMinute;
    public Button taketime,taketimeend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject_single);

        mAdeptar= new RecyclerAdapterFriday();
        showFridaySchedule= new showFridaySchedule();

        mydb = new DataBaseHelper(this);
        setupUIViews();
        addData();
    }
    private void setupUIViews() {

        sttime = (EditText) findViewById(R.id.startingTime);
        edtime = (EditText) findViewById(R.id.endingTime);
        subname = (EditText) findViewById(R.id.subjectName);
        //listView = (ListView) findViewById(R.id.lvsubDesc);
        dbList= new ArrayList<DatabaseModelFriday>();
        btnsubmit = (Button) findViewById(R.id.btnsubmit);
        viewallbtn = (Button) findViewById(R.id.viewallbtn);
        tvdisplay = (TextView) findViewById(R.id.tvdisplay);
        taketime= (Button)findViewById(R.id.taketime);
        taketimeend= (Button)findViewById(R.id.taketimeend);

        mCalendar = Calendar.getInstance();

        taketime.setOnClickListener(this);
        taketimeend.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(v==taketime)
        {
            final Calendar c =Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if(hourOfDay == 0)
                        hourOfDay=hourOfDay+12;

                    else if(hourOfDay >12)
                        hourOfDay=hourOfDay-12;

                    taketime.setText(hourOfDay+":"+minute);
                }
            },mHour,mMinute,false);
            timePickerDialog.show();
        }

        if(v==taketimeend)
        {
            final Calendar c =Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if(hourOfDay == 0)
                        hourOfDay=hourOfDay+12;

                    else if(hourOfDay >12)
                        hourOfDay=hourOfDay-12;

                    taketimeend.setText(hourOfDay+":"+minute);
                }
            },mHour,mMinute,false);
            timePickerDialog.show();
        }
    }

    public void addData(){
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject=subname.getText().toString();
                String starting_time =taketime.getText().toString();
                String end_time=taketimeend.getText().toString();

                if(taketime.equals("") )
                    Toast.makeText(schedule_friday.this,"Starting Time Empty !",Toast.LENGTH_SHORT).show();
                else if(taketimeend.equals(""))
                    Toast.makeText(schedule_friday.this,"Ending Time Empty !",Toast.LENGTH_SHORT).show();
                else if(subject.equals(""))
                    Toast.makeText(schedule_friday.this,"Subject Name Empty !",Toast.LENGTH_SHORT).show();

                else {

                    mydb.insertDataFriday(subject, starting_time, end_time);
                    mAdeptar.notifyDataSetChanged();
                    mAdeptar.notifyItemRangeChanged(0,dbList.size());
                    int id=mydb.returnidnoFriday();
                    Log.d("findid","ID ="+" "+id);
                    mAdeptar.notifyItemInserted(id);
                    Toast.makeText(schedule_friday.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    //                  refreshpage();
                }
                taketime.setText("Starting Time");
                taketimeend.setText("Ending Time");
                subname.setText(null);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent intent;
        super.onBackPressed();
        intent= new Intent(schedule_friday.this,week_activity.class);
        startActivity(intent);
        finish();
    }

}
