package com.example.skyroot.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResultDB {

    String date;
    int result;

    ResultDB(){
        date="DD/MM/YYYY";
        result=0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    ResultDB(int result){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        this.date=date;
        this.result=result;

    }
    ResultDB(String date, int result)
    {
        this.date = date;
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public int getResult() {
        return result;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
