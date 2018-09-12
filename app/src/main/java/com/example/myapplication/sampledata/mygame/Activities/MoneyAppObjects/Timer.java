package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.GameModesActivities.AgainstTime;

@SuppressLint("Registered")
public class Timer {
    private double sec_to_reach_target_number = 0;
    private CountDownTimer count_down_timer;

    public Timer(CountDownTimer count_down_timer) {
        this.count_down_timer = count_down_timer;
    }

    public void start_count_down_timer() {
        count_down_timer.start();
    }

    public void cancel_count_down_timer()

    {
        count_down_timer.cancel();
    }

    public double get_sec_to_reach_target() {
        return sec_to_reach_target_number;
    }

    public void reset_sec_to_reach_target() {
        sec_to_reach_target_number = 0;
    }

//    public void new_time_for_count_down(long new_time) {
//        cancel_count_down_timer();
//        time_remaining = new_time;
//        create_count_down_timer();
//        start_count_down_timer();
//    }

    public void set_cound_down_timer(CountDownTimer count_down_timer){
        this.count_down_timer = count_down_timer;
    }
}
