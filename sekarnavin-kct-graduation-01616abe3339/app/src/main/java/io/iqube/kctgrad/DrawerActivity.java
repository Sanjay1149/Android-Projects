package io.iqube.kctgrad;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class DrawerActivity extends AppCompatActivity implements FeedbackFragment.OnFragmentInteractionListener{


    private static final int PROFILE_SETTING = 100000;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private AccountHeader headerResult = null;
    private Drawer result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences gcm = getSharedPreferences("gcm",getApplicationContext().MODE_PRIVATE);
        String reg = gcm.getString("reg", "");
        if(!reg.equals("yes")) {
            regGcm();
        }
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().endsWith(GCMRegistrationIntentService.REGISTRATION_SUCCESS)) {
                    String token = intent.getStringExtra("token");
                    String topic = intent.getStringExtra("topic");
                } else if (intent.getAction().equals(GCMRegistrationIntentService.REGISTRATION_ERROR)) {

                    Toast.makeText(getApplicationContext(), "Error in Receiving Notification", Toast.LENGTH_LONG).show();
                } else {

                }
            }
        };

        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.makerfair_slide03)
                .withSavedInstance(savedInstanceState)
                .build();

        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIdentifier(7),
                        new PrimaryDrawerItem().withName("Agenda").withIdentifier(2),
                        new PrimaryDrawerItem().withName("About Speakers").withIdentifier(6),
                        new PrimaryDrawerItem().withName("Map").withIdentifier(4),
                        new PrimaryDrawerItem().withName("Notifications").withIdentifier(3),
                        new PrimaryDrawerItem().withName("Participants").withIdentifier(9)

                         ) // add the items we want to use with our Drawer
                .addStickyDrawerItems(
                        new PrimaryDrawerItem().withName("About").withIdentifier(5)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        //check if the drawerItem is set.
                        //there are different reasons for the drawerItem to be null
                        //--> click on the header
                        //--> click on the footer
                        //those items don't contain a drawerItem

                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 2) {
//                                intent = new Intent(DrawerActivity.this, CompactHeaderDrawerActivity.class);
                                Fragment a = AgendaFragment.newInstance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, a).commit();
                            }

                            if (drawerItem.getIdentifier() == 6) {
//                                intent = new Intent(DrawerActivity.this, CompactHeaderDrawerActivity.class);
                                Fragment a = about_guest.newInstance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, a).commit();
                            }

                            if (drawerItem.getIdentifier() == 3) {
//                                intent = new Intent(DrawerActivity.this, CompactHeaderDrawerActivity.class);
                                Fragment f = NotificationFragment.newInstance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, f).commit();
                            }

                            if (drawerItem.getIdentifier() == 5) {
//                                intent = new Intent(DrawerActivity.this, CompactHeaderDrawerActivity.class);
                                Fragment f = AboutFragment.newInstance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, f).commit();
                            }
                            if (drawerItem.getIdentifier() == 4) {
//                                intent = new Intent(DrawerActivity.this, CompactHeaderDrawerActivity.class);
                                Fragment a = map.newInstance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, a).commit();
                            }
                            if (drawerItem.getIdentifier() == 7) {
//                                intent = new Intent(DrawerActivity.this, CompactHeaderDrawerActivity.class);
                                Fragment a = home.newInstance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, a).commit();
                            }
                            if(drawerItem.getIdentifier() == 9){
//                                intent = new Intent(DrawerActivity.this, CompactHeaderDrawerActivity.class);
                                Fragment a = participants.newInstance();
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,a).commit();
                            }


                            if (intent != null) {
                                DrawerActivity.this.startActivity(intent);
                            }
                        }

                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();

        //only set the active selection or active profile if we do not recreate the activity
        if (savedInstanceState == null) {
            // set the selection to the item with the identifier 11
            result.setSelection(7, true);


            result.openDrawer();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("MainActivity", "onResume");
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver, new IntentFilter(GCMRegistrationIntentService.REGISTRATION_SUCCESS));
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver, new IntentFilter(GCMRegistrationIntentService.REGISTRATION_ERROR));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("MainActivity", "onPause");
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
    }



    public void regGcm() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (ConnectionResult.SUCCESS != resultCode) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                Toast.makeText(getApplicationContext(), "Google Play Service is not Enabled in this device!", Toast.LENGTH_LONG).show();
                GooglePlayServicesUtil.showErrorNotification(resultCode, getApplication());
            } else {
                Toast.makeText(getApplicationContext(), "This device does not support for Google Play Service!", Toast.LENGTH_LONG).show();
            }
        } else {
            Intent intent = new Intent(this, GCMRegistrationIntentService.class);
            startService(intent);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void fun()
    {

    }



   

}