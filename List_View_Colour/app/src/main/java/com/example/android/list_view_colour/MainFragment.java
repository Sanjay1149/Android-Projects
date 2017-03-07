package com.example.android.list_view_colour;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by sanjaypradeep on 26-07-2016.
 */
public class MainFragment extends Fragment {

    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview =inflater.inflate(R.layout.list_view,container,false);

        String[] color = {"RED","BLACK","YELLOW","BLUE","PINK","WHITE"};

        ArrayAdapter adapter = new ArrayAdapter(rootview.getContext(),R.layout.list_item_text,R.id.list_text,color);

        ListView list = (ListView) rootview.findViewById(R.id.listcolor);
        list.setAdapter(adapter);

        return rootview;
    }
}
