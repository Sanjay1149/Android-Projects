package com.example.android.small_try;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv1 = new TextView(this);
        tv1.setText("Hello I'm awesome");
        tv1.setTextSize(40);
        tv1.setTextColor(Color.RED);

        ImageView im1 = new ImageView(this);
        im1.setImageResource(R.drawable.doc4);
        im1.setScaleType(ImageView.ScaleType.FIT_XY);
        im1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        TextView tv2 = new TextView(this);
        tv2.setTextColor(Color.BLUE);
        tv2.setText("This is superman to rescue !!!!");
        tv2.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
        tv2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        tv2.setTextSize(50);

        FrameLayout fr = new FrameLayout(this);
        fr.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        fr.addView(tv1);
        fr.addView(im1);
        fr.addView(tv2);
        setContentView(fr);
    }
}
