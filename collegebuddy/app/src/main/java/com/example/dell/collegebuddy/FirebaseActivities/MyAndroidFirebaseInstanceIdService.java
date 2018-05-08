package com.example.dell.collegebuddy.FirebaseActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import static android.content.ContentValues.TAG;

public class MyAndroidFirebaseInstanceIdService extends FirebaseInstanceIdService{

    public static final String TOKEN_BROADCAST="myfcmtokenbroadcast";
        @Override
        public void onTokenRefresh() {
            // Get updated InstanceID token.
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            Log.d("myfirebaseid", "Refreshed token: " + refreshedToken);

            getApplicationContext().sendBroadcast(new Intent(TOKEN_BROADCAST));
            storeToken(refreshedToken);
        }

    private void storeToken(String refreshedToken) {

        SharedManagerFCMToken.getInstance(getApplicationContext()).storeToken(refreshedToken);
    }
}

