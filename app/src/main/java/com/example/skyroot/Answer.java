package com.example.skyroot;

public class Answer {

    String answer;
    String result;

    Answer() {
        answer = "";
        result = "";

    }

    Answer(String answer, String result) {
        this.answer = answer;
        this.result = result;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }
    public String getResult() {
        return this.result;
    }
    public void setResult(String result){
        this.result = result;
    }


}
