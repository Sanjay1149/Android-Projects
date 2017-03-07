package com.example.android.list_view_colour;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by sanjaypradeep on 10-08-2016.
 */
public class ImageAdapter extends BaseAdapter {

    Context c;

    ImageAdapter(Context context)
    {
        c = context;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int in, View view, ViewGroup viewGroup) {
        ImageView imageView;

        ArrayList colorList = new ArrayList();

        imageView = new ImageView(c);
        for(int i=0;i<colors.length;i++){
            colorList.add(Color.parseColor("#"+colors[i]));
        }

        imageView.setBackgroundColor(colorList.get(in));
        return imageView;
    }

    String[] colors = { "822111", "AC2B16", "CC3A21", "E66550", "EFA093", "F6C5BE" , "3DC789" };
}
