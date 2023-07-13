package com.example.skyroot;
import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.skyroot.data.DBHandler;
import com.example.skyroot.data.ResultDB;

import java.util.ArrayList;
public class ResultAdapter implements ListAdapter {

    ArrayList<ResultDB> results;
    Context context;

    public ResultAdapter(Context context,ArrayList<ResultDB> result){
        this.context = context;
        this.results = result;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ResultDB result= results.get(position);

        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.customlistview, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            TextView answerCurrent=convertView.findViewById(R.id.text1);
            TextView resultCurrent=convertView.findViewById(R.id.text2);

            answerCurrent.setText(result.getDate());
            resultCurrent.setText(String.valueOf(result.getResult()));
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return results.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
