package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;

import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.myapplication.R;

public class Timer {
    private TextView[] count_down_views;
    private long time_remaining;
    private double sec_to_reach_target_number = 0;
    private CountDownTimer count_down_timer;

    public Timer(TextView[] count_down_views, long time_remaining){
        this.count_down_views = count_down_views;
        this.time_remaining = time_remaining;
    }

    public void create_count_down_timer() {
        count_down_timer = new CountDownTimer(time_remaining, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                for (TextView count_down_view : count_down_views) {
                    count_down_view.setText(String.valueOf(millisUntilFinished / 1000));
                }
                sec_to_reach_target_number += 1;
                if (10000 > millisUntilFinished) {
                    for (TextView count_down_view : count_down_views) {
                        count_down_view.setBackgroundResource(R.drawable.clock_end_of_time);
                    }

                }
            }

            @Override
            public void onFinish() {
                for (TextView count_down_view : count_down_views) {
                    count_down_view.setText(String.valueOf(0));
                }
                count_down_timer.cancel();
            }
        };
    }

    public void start_count_down_timer(){
        count_down_timer.start();
    }
    public void cancel_count_down_timer()

    {
        count_down_timer.cancel();
    }

    public double get_sec_to_reach_target(){
        return sec_to_reach_target_number;
    }

    public void reset_sec_to_reach_target(){
        sec_to_reach_target_number = 0;
    }

    public void new_time_for_count_down(long new_time){
        cancel_count_down_timer();
        time_remaining = new_time;
        create_count_down_timer();
        start_count_down_timer();
    }
}
