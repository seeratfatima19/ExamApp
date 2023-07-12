package com.example.skyroot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CurrentResultFragment extends Fragment {

    public CurrentResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = new Bundle();
        ArrayList<String> result = bundle.getStringArrayList("checked");
        ArrayList<String> answer = bundle.getStringArrayList("answers");
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_current_result, container, false);




        return view;
    }
}