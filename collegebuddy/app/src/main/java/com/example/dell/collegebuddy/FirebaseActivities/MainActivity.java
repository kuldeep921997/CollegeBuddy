package com.example.dell.collegebuddy.FirebaseActivities ;
 
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
 
public class MainActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Intent getIntent = getIntent();
        final String SuperADMIN="SuperADMIN";
        String normalUSER ="normalUSER";

        final String usertypehere = getIntent.getExtras().getString("usertype");

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }

                else if(usertypehere.equals(SuperADMIN))
                {
                    Intent intent = new Intent(MainActivity.this,firebase_super_user.class);
                    startActivity(intent);
                }

                else{
                    Intent intent = new Intent(MainActivity.this,normalUsers.class);
                    startActivity(intent);
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