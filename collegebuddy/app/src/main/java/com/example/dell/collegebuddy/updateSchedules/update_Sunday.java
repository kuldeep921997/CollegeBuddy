package com.example.dell.collegebuddy.updateSchedules;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dell.collegebuddy.DataBaseHelper;
import com.example.dell.collegebuddy.DatabaseModelSunday;
import com.example.dell.collegebuddy.R;
import com.example.dell.collegebuddy.RecyclerAdapter;
import com.example.dell.collegebuddy.RecyclerAdapterSunday;
import com.example.dell.collegebuddy.showDaySchedule.showSundaySchedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class update_Sunday extends AppCompatActivity implements View.OnClickListener {
    RecyclerAdapterSunday mAdeptar;
    showSundaySchedule showSundaySchedule;
    DataBaseHelper mydb;
    public EditText subname;
    private int mHour,mMinute;
    public TextView tvdisplay;
    public Button btnsubmit;
    public String idherenow;
    public Button taketime,taketimeend;
    public Button viewallbtn;
    public Calendar mCalendar;
    List<DatabaseModelSunday> dbList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject_single);
        mAdeptar= new RecyclerAdapterSunday();
        showSundaySchedule= new showSundaySchedule();
        mydb = new DataBaseHelper(this);
        setupUIViews();
        UpdateData();
    }
    private void setupUIViews() {

        taketime= (Button)findViewById(R.id.taketime);
        taketimeend= (Button)findViewById(R.id.taketimeend);
        subname = (EditText) findViewById(R.id.subjectName);
        dbList= new ArrayList<DatabaseModelSunday>();
        btnsubmit = (Button) findViewById(R.id.btnsubmit);
        viewallbtn = (Button) findViewById(R.id.viewallbtn);
        tvdisplay = (TextView) findViewById(R.id.tvdisplay);
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

    public void UpdateData(){
        idherenow = getIntent().getExtras().getString("id");
        btnsubmit.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                String subject=subname.getText().toString();
                                                String starting_time =taketime.getText().toString();
                                                String end_time=taketimeend.getText().toString();

                                                if(taketime.equals("") )
                                                    Toast.makeText(update_Sunday.this,"Starting Time Empty !",Toast.LENGTH_SHORT).show();
                                                else if(taketimeend.equals(""))
                                                    Toast.makeText(update_Sunday.this,"Ending Time Empty !",Toast.LENGTH_SHORT).show();
                                                else if(subject.equals(""))
                                                    Toast.makeText(update_Sunday.this,"Subject Name Empty !",Toast.LENGTH_SHORT).show();


                                                else {
                                                    mydb.updateDataSunday(idherenow,subject, starting_time, end_time);
                                                    mAdeptar.notifyDataSetChanged();
                                                    mAdeptar.notifyItemRangeChanged(0,dbList.size());
                                                    //mAdeptar.notifyItemInserted(id);
                                                    Toast.makeText(update_Sunday.this, "Data Updated", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(update_Sunday.this,showSundaySchedule.class);
                                                    startActivity(i);
                                                }

                                            }
        });

    }
}