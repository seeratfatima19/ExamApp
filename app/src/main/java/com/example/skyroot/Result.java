package com.example.skyroot;

public class Result {
    String date;
    int result;

    Result(){
        date="";
        result=-1;
    }

    Result(String date, int result){
        this.date = date;
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
