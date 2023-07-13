package com.example.skyroot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.skyroot.data.DBHandler;
import com.example.skyroot.data.ResultDB;

import java.util.ArrayList;

public class ResultFragment extends Fragment {

    DBHandler dbhandler;
    ListView listView;
    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_result, container, false);
        dbhandler=new DBHandler(getActivity());
        ArrayList<ResultDB> resultArray = new ArrayList<ResultDB>();
        resultArray= dbhandler.returnDb();

        System.out.println(resultArray);
        listView = (ListView) view.findViewById(R.id.listViewFinal);

        ResultAdapter adapter = new ResultAdapter(getActivity(), resultArray);
        listView.setAdapter(adapter);

        return view;
    }
}