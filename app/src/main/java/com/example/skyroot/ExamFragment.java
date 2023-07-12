package com.example.skyroot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

public class ExamFragment extends Fragment {


    RadioButton skybtn, rootBtn, grassBtn;
    TextView textView;


    public ExamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_exam, container, false);
        textView = (TextView) view.findViewById(R.id.question);
        skybtn = (RadioButton) view.findViewById(R.id.sky_radio);
        rootBtn = (RadioButton) view.findViewById(R.id.root_radio);
        grassBtn = (RadioButton) view.findViewById(R.id.grass_radio);

        return view;
    }
}