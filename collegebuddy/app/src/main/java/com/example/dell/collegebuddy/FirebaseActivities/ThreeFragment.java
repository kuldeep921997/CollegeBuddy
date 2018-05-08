package com.example.dell.collegebuddy.FirebaseActivities ;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.collegebuddy.R;
import com.example.dell.collegebuddy.noticeModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ThreeFragment extends Fragment{


    private EditText subname;
    private Button button;
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    String SubjectHolder,SubjectTimeHolder,SubjectDateHolder;
    String taketime;
    String dateformat;

    public Calendar mCalendar;
    private int mHour,mMinute;



    public ThreeFragment() {
        // Required empty public constructor
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference("notices");

    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_three, container, false);

        subname = (EditText)v.findViewById(R.id.SubjectNotice);
        button = (Button)v.findViewById(R.id.noticebtn);

                mCalendar = Calendar.getInstance();


            final Calendar c =Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

                    if(mHour == 0)
                        mHour=mHour+12;

                    else if(mHour >12)
                        mHour=mHour-12;

                    taketime = mHour+":"+mMinute;

                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    dateformat = df.format(c.getTime());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubjectHolder=subname.getText().toString().trim();
                SubjectTimeHolder= taketime ;
                SubjectDateHolder= dateformat;
                noticeModel notice = new noticeModel() ;
                notice.setSubject(SubjectHolder);
                notice.setStarting_time(SubjectTimeHolder);
                notice.setStarting_date(SubjectDateHolder);
                String StudentRecordIDFromServer = databaseReference.push().getKey();
                databaseReference.child(StudentRecordIDFromServer).setValue(notice);
                Toast.makeText(getActivity(),"Data Inserted Successfully into Firebase Database", Toast.LENGTH_SHORT).show();
            }
        });
        return v ;
    }
}