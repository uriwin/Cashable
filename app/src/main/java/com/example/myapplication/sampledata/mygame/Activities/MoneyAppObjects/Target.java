package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import java.util.stream.DoubleStream;

public class Target {

    private int target_number;
    private int max_target_number;
    private TextView textView;

    public Target(int number, TextView text_view, int max_target_number) {
        this.target_number = number;
        this.textView = text_view;
        this.max_target_number = max_target_number;

        textView.setText(String.valueOf(target_number));
    }

    public int get_target_number() {
        return target_number;
    }

    public void set_Target_number(int new_number) {
        target_number = new_number;
        textView.setText(String.valueOf(target_number));
    }

    public int get_max_target_number() {
        return max_target_number;
    }


    public int minimum_actions_to_reach_target(List<Integer> cash_values){
        if (cash_values.contains(35)){
            return minimum_actions_to_reach_infinity_target(cash_values);
        }

        int counter = 0;

        for (Integer bill_value : cash_values) {
            if (target_number / bill_value != 0) {

                int bill_counter = target_number / bill_value;
                target_number -= bill_counter * bill_value;
                counter += bill_counter;
            }
        }
        if (target_number == 0)
            return counter;

        counter += 1;
        return counter;
    }


    @TargetApi(Build.VERSION_CODES.N)
    private int minimum_actions_to_reach_infinity_target(List<Integer> cash_values){
        int counter = 0;
        double[] dead_end_numbers = {10.0, 30.0};

        if (target_number % 10 == 5) {
            target_number -= 35;
            counter += 1;
        }

        for (Integer bill_value : cash_values) {
            if (bill_value <= target_number) {
                double module = target_number % bill_value;
                if (DoubleStream.of(dead_end_numbers).noneMatch(x -> x == module)) {
                    int bill_counter = target_number / bill_value;
                    target_number -= bill_counter * bill_value;
                    Log.d("target number", "target number= " + String.valueOf(target_number));
                    Log.d("target number", String.format("%d used %d", bill_value, bill_counter));
                    counter += bill_counter;
                }
            }
            if (target_number == 0)
                return counter;
        }
        return counter;

    }

}
