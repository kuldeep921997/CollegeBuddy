package com.example.dell.collegebuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.example.dell.collegebuddy.FirebaseActivities.LoginActivity;
import com.example.dell.collegebuddy.FirebaseActivities.ShowSubjectDetailsActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SubjectFromFire extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {

                    Intent i = new Intent(SubjectFromFire.this, LoginActivity.class);
                    Log.d("TAGOFFIRE", "inseide login");
                    startActivity(i);
                    finish();
                } else {
                    Intent intent = new Intent(SubjectFromFire.this, ShowSubjectDetailsActivity.class);
                    Log.d("TAGOFFIRE", "inseide schedule");
                    startActivity(intent);
                    finish();
                }
            }
        };
    }



    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }



}