package com.example.android.bucky_frag;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sanjaypradeep on 18-07-2016.
 */
public class TopFragment extends Fragment {

    TopFragmentInterface top;

    public interface TopFragmentInterface {
       public void creatememe(String top,String bottom);
   }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
       try {
           top = (TopFragmentInterface) activity;
       }
       catch (ClassCastException e) {
           throw new ClassCastException(activity.toString());
       }
    }

    EditText edit1;
    EditText edit2;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment,container,false);

        edit1 = (EditText) view.findViewById(R.id.san_edit1);
        edit2= (EditText) view.findViewById(R.id.san_edit2);

        button = (Button) view.findViewById(R.id.san_button);

        button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        buttonclicked(view);
                    }
                }
        );

        return view;
    }

    public void buttonclicked(View v){
        top.creatememe(edit1.getText().toString(),edit2.getText().toString());
    }
}
