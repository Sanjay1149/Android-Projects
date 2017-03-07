package com.example.android.bucky_frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sanjaypradeep on 18-07-2016.
 */
public class BottomFragment extends Fragment {

    TextView text1;
    TextView text2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment,container,false);

        text1 = (TextView) view.findViewById(R.id.san_text1);
        text2 = (TextView) view.findViewById(R.id.san_text2);
        return view;
    }

    public void settext(String top,String bottom){
        text1.setText(top);
        text2.setText(bottom);
    }
}
