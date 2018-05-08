package com.example.dell.collegebuddy.FirebaseActivities ;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedManagerFCMToken{
	
	private static Context mCtx;
	private static SharedManagerFCMToken mInstance;
	private static final String SHARED_PREF_NAME="fcmsharedprefdemo";
	private static final String KEY_ACCESS_TOKEN="token";

	private SharedManagerFCMToken(Context context){
		mCtx=context;
	}

public static synchronized SharedManagerFCMToken getInstance(Context context){

	if (mInstance==null) 
		mInstance = new SharedManagerFCMToken(context);		
	return mInstance;
}

public boolean storeToken(String token){
	SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
	SharedPreferences.Editor editor =sharedPreferences.edit();
	editor.putString(KEY_ACCESS_TOKEN,token);
	editor.apply();
	return true;
}

public String getToken(){
	SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
	return sharedPreferences.getString(KEY_ACCESS_TOKEN,null);

}

}