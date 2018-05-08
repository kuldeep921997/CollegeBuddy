package com.example.dell.collegebuddy.FirebaseActivities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.collegebuddy.FirebaseActivities.Monday.Mondaydetails;
import com.example.dell.collegebuddy.FirebaseActivities.RecyclerAdapter.RecyclerViewAdapterFriday;
import com.example.dell.collegebuddy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class ShowFridayDetailsActivity extends AppCompatActivity {


    DatabaseReference databaseReference;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    List<Mondaydetails> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase_activity_show_student_details);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowFridayDetailsActivity.this));
        progressDialog = new ProgressDialog(ShowFridayDetailsActivity.this);
        progressDialog.setMessage("Loading Data from Firebase Database");
        progressDialog.show();


        database=FirebaseDatabase.getInstance();
        databaseReference = database.getReference("friday");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Mondaydetails mondaydetails = dataSnapshot.getValue(Mondaydetails.class);
                    list.add(mondaydetails);
                }

                adapter = new RecyclerViewAdapterFriday(ShowFridayDetailsActivity.this, list);
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