package com.example.dell.collegebuddy.FirebaseActivities ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.dell.collegebuddy.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TwoFragment extends Fragment{

    private EditText subname,subfullname,subjectType;
    private Button button,btnview;
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    String SubjectHolder, SubjectFullHolder,SubjectTypeFullHolder;


    public TwoFragment() {
        // Required empty public constructor
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference("subjects");
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.subjects, container, false);
        subname = (EditText)v.findViewById(R.id.subnameinsub);
        subfullname = (EditText)v.findViewById(R.id.fullnameinsub);
        subjectType = (EditText)v.findViewById(R.id.subjectType);
        button = (Button)v.findViewById(R.id.btnsub);
        btnview = (Button)v.findViewById(R.id.btnview);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubjectHolder = subname.getText().toString().trim();
                SubjectFullHolder = subfullname.getText().toString().trim();
                SubjectTypeFullHolder = subjectType.getText().toString().trim();

                if (SubjectHolder.equals("") || SubjectFullHolder.equals("") || SubjectTypeFullHolder.equals(""))
                    Toast.makeText(getActivity(), "Please Ensert Correct Data At Required Field", Toast.LENGTH_SHORT).show();
                else {
                    subjects subjects1 = new subjects();
                    subjects1.setSubject(SubjectHolder);
                    subjects1.setFullsubject(SubjectFullHolder);
                    subjects1.setSubjetType(SubjectTypeFullHolder);
                    String StudentRecordIDFromServer = databaseReference.push().getKey();
                    databaseReference.child(StudentRecordIDFromServer).setValue(subjects1);
                    Toast.makeText(getActivity(), "Data Inserted Successfully into Server Database", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShowSubjectDetailsActivity.class);
                startActivity(intent);
            }
        });
        return v ;
    }
}