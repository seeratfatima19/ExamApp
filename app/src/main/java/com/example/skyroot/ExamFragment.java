    package com.example.skyroot;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ExamFragment extends Fragment {


    AppCompatButton endButton;
    RadioButton skybtn, rootBtn, grassBtn;
    RadioGroup radioGroup;
    TextView textView;
    String [] skyLetter = {"d","h","l","k","t","b","f"};
    String [] grassLetter = {"a","c","e","i","m","n","o","r","s","u","v","w","x","z"};
    String [] rootLetter = {"g","j","p","q","y"};
    String[] answers= new String[5];
    static String category="";
    int correctCount=0;
    public ExamFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_exam, container, false);
        textView = (TextView) view.findViewById(R.id.question);
        skybtn = (RadioButton) view.findViewById(R.id.sky_radio);
        rootBtn = (RadioButton) view.findViewById(R.id.root_radio);
        grassBtn = (RadioButton) view.findViewById(R.id.grass_radio);
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        endButton= (AppCompatButton) view.findViewById(R.id.end_button);

        String question =generateLetter();
        textView.setText(question);

        skybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(category.equals("Sky Letter")){
                    correctCount++;
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String question =generateLetter();
                        textView.setText(question);
                    }
                }, 2000);
            }
        });

        grassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(category.equals("Grass Letter")){
                    correctCount++;
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String question =generateLetter();
                        textView.setText(question);
                    }
                }, 2000);
            }
        });

        rootBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(category.equals("Root Letter")){
                    correctCount++;
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String question =generateLetter();
                        textView.setText(question);
                    }
                }, 2000);
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("correct count: "+correctCount);
            }
        });

        /*
        for(int i=0;i<5;i++){

            String question =generateLetter();
            textView.setText(question);
            String answer = "";

            System.out.println("in loop");

                if(skybtn.isChecked()){
                System.out.println("sky letter checked");
                if(category.equals("Sky Letter")){
                    correctCount++;
                }
            }
            else if(rootBtn.isChecked()){
                System.out.println("root letter checked");
                if(category.equals("Root Letter")){
                    correctCount++;
                }
            }
            else if(grassBtn.isChecked()){
                System.out.println("grass letter checked");
                if (category.equals("Grass Letter")) {
                    correctCount++;
                }
            }

            System.out.println("correct count: "+correctCount);

       }

*/
        return view;
    }

    private String generateLetter(){
        int random = (int) (Math.random()*3);
        if(random == 0){
            category="Sky Letter";
            return skyLetter[(int) (Math.random()*skyLetter.length)];
        }
        else if(random == 1){
            category="Grass Letter";
            return grassLetter[(int) (Math.random()*grassLetter.length)];
        }
        else{
            category="Root Letter";
            return rootLetter[(int) (Math.random()*rootLetter.length)];
        }
    }
}