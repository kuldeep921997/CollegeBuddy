package com.example.dell.collegebuddy;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class Actual_Notices extends AppCompatActivity {


    DatabaseReference databaseReference;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    List<noticeModel> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticeadapter);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Actual_Notices.this));
        progressDialog = new ProgressDialog(Actual_Notices.this);
        progressDialog.setMessage("Loading Data from Firebase Database");
        progressDialog.show();

        database=FirebaseDatabase.getInstance();
        databaseReference = database.getReference("notices");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    noticeModel noticemodel = dataSnapshot.getValue(noticeModel.class);
                    list.add(noticemodel);
                }

                adapter = new notice_Adapter(Actual_Notices.this, list);
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