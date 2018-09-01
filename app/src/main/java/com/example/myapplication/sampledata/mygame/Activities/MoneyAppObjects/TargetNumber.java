package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;


import android.util.Log;
import android.widget.TextView;

public class TargetNumber {

    private int target_number;
    private int max_target_number;
    private TextView textView;

    public TargetNumber(int number, TextView text_view, int max_target_number) {
        this.target_number = number;
        this.textView = text_view;
        this.max_target_number = max_target_number;

        textView.setText(String.valueOf(target_number));
    }

    public int get_Target_number() {
        return target_number;
    }

    public void set_Target_number(int new_number) {
        target_number = new_number;
        textView.setText(String.valueOf(target_number));
    }

    public int get_max_target_number() {
        return max_target_number;
    }
}
