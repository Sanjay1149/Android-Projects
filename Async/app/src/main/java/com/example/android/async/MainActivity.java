package com.example.android.async;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new download().execute();
    }
    private class download extends AsyncTask<String, Void, JSONArray> {

        ProgressDialog progressdialog;

        @Override
        protected JSONArray doInBackground(String... params) {
            JSONArray jsonArray = null;
                URL url = null;
                try {
                    url = new URL(params[0]);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(7000);
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    StringBuilder builder = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                        builder.append("\n");
                    }
                    try {
                        jsonArray = new JSONArray(builder.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }catch (SocketTimeoutException e){
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"Slow Internet Connection \n Check your connection and try again",Toast.LENGTH_LONG).show();
                    }
                });
            }catch (IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"Error Retrieving Data\n Check your Connection and Try again",Toast.LENGTH_LONG).show();
                    }
                });
            }
            return jsonArray;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressdialog = new ProgressDialog(MainActivity.this);
            progressdialog.setMessage("Contacting Server.. Please Wait..");
            progressdialog.setTitle("Processing");
            progressdialog.setCanceledOnTouchOutside(false);
            progressdialog.setCancelable(false);
            progressdialog.show();

        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            super.onPostExecute(jsonArray);
            progressdialog.dismiss();
        }



    }
}


