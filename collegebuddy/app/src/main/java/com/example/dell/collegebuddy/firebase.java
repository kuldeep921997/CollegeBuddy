package com.example.dell.collegebuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class firebase extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private TextView showText;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase);

        //textView= (TextView)findViewById(R.id.firebase);
            editText= (EditText) findViewById(R.id.msgfrmfire);
            button= (Button)findViewById(R.id.fire);
            showText=(TextView)findViewById(R.id.showtext);

            database= FirebaseDatabase.getInstance();

            //reference to child..
            myRef= database.getReference("this");

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //value is taken from the text field.
                    String value=editText.getText().toString();

                    //instance of database..

                    //myRef2=new FirebaseDatabase("http://college-buddy-a9d42.firebaseio.com/message");
                    //setting the chile value..
                    myRef.setValue(value);
                    //myRef.push().setValue(value);


                }
            });

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
               String valuefrmfb = (String) dataSnapshot.getValue();
               showText.setText(valuefrmfb);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    showText.setText("the value is not found in database... ");
                }
            });
    }
}