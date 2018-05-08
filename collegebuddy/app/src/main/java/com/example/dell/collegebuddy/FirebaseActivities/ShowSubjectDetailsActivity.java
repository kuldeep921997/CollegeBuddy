package com.example.dell.collegebuddy.FirebaseActivities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.dell.collegebuddy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class ShowSubjectDetailsActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    List<subjects> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase_activity_show_student_details);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowSubjectDetailsActivity.this));
        progressDialog = new ProgressDialog(ShowSubjectDetailsActivity.this);
        progressDialog.setMessage("Loading Data from Server Database");
        progressDialog.show();


        database=FirebaseDatabase.getInstance();
        databaseReference = database.getReference("subjects");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    subjects subjects1 = dataSnapshot.getValue(subjects.class);
                    list.add(subjects1);
                }
                adapter = new SubjectAdapter(ShowSubjectDetailsActivity.this, list);
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
    }
}