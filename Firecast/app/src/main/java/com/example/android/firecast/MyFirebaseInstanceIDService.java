package com.example.android.firecast;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.storage.StorageReference;

/**
 * Created by sanjaypradeep on 02-10-2016.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Refreshed token: "+refreshedToken);

        sendRegistrationService(refreshedToken);
    }

    private  void sendRegistrationService(String token){

    }
}
