package com.example.skyroot;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;

public class CurrentResultFragment extends Fragment {

    TextView textView;
    ListView listView;
    public CurrentResultFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = new Bundle();
        bundle= getArguments();
        ArrayList<String> result = new ArrayList<>();
                result = bundle.getStringArrayList("checked");
        ArrayList<String> answer = new ArrayList<>();
                answer = bundle.getStringArrayList("answers");


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_current_result, container, false);
        //textView= (TextView)view.findViewById(R.id.dataDisplay);
        listView= (ListView)view.findViewById(R.id.listViewCurrent);
        ArrayList<Answer> answerList = new ArrayList<>();
       for(int i = 0; i < answer.size(); i++) {
           //textView.setText("Your answer "+ answer.get(i)+" is "+ result.get(i)+"\n");

           System.out.println(answer.get(i));
          answerList.add(new Answer(answer.get(i), result.get(i))) ;

        }

        CustomAdapter adapter = new CustomAdapter(getActivity(), answerList);
       listView.setAdapter(adapter);






        return view;
    }

}

