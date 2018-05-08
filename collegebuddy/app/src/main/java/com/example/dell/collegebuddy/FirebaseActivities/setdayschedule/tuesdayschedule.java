package com.example.dell.collegebuddy.FirebaseActivities.setdayschedule;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.dell.collegebuddy.ConnectivityReceiver;
import com.example.dell.collegebuddy.FirebaseActivities.Monday.Mondaydetails;
import com.example.dell.collegebuddy.FirebaseActivities.ShowTuesdayDetailsActivity;
import com.example.dell.collegebuddy.R;
import com.example.dell.collegebuddy.internetcheker;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tuesdayschedule extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

    Button SubmitButton ;
    Button DisplayButton;
    EditText subject, sttime ,endtime;
    String SubjectHolder, Starting_timeHolder,Ending_timeHolder;
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference("tuesday");
        SubmitButton = (Button)findViewById(R.id.fire);
        DisplayButton = (Button)findViewById(R.id.show);
        subject= (EditText)findViewById(R.id.subject);
        sttime = (EditText)findViewById(R.id.sttime);
        endtime = (EditText)findViewById(R.id.endtime);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mondaydetails mondaydetails = new Mondaydetails() ;
                checkConnection();
                GetDataFromEditText();
                mondaydetails.setSubject (SubjectHolder);
                mondaydetails.setStarting_time(Starting_timeHolder);
                mondaydetails.setEnding_time(Ending_timeHolder);
                String StudentRecordIDFromServer = databaseReference.push().getKey();
                databaseReference.child(StudentRecordIDFromServer).setValue(mondaydetails);
                Toast.makeText(tuesdayschedule.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_SHORT).show();
            }
        });

        DisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tuesdayschedule.this, ShowTuesdayDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void GetDataFromEditText(){
        SubjectHolder = subject.getText().toString().trim();
        Starting_timeHolder = sttime.getText().toString().trim();
        Ending_timeHolder = endtime.getText().toString().trim();
    }

    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.WHITE;
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.RED;
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        internetcheker.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }

}