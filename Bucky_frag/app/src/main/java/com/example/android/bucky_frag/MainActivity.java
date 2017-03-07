package com.example.android.bucky_frag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TopFragment.TopFragmentInterface {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void creatememe(String top, String bottom) {
        BottomFragment bot = (BottomFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bot.settext(top,bottom);
    }
}
