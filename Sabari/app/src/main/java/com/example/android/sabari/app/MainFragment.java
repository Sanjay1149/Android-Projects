package com.example.android.sabari.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by sanjaypradeep on 17-07-2016.
 */
public class MainFragment extends Fragment {
    View root;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.list_view,container,false);

        String[] myarray={"asd","asdasd","dadas","dsadsad"};

        ArrayAdapter myadapter=new ArrayAdapter(root.getContext(),R.layout.item,R.id.text,myarray);
        ListView mylist=(ListView)root.findViewById(R.id.listView);
        mylist.setAdapter(myadapter);


        return root;
    }

}
