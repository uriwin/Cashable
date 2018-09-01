package com.example.myapplication.sampledata.mygame.Activities.GameModesActivities;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.BasicGame;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.CashRegister;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Money;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.TargetNumber;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;


public class Infinity extends BasicGame {
    private long time_play = 16000;
    private int min_clicks_to_reach_target_number;
    protected TextView CountDownCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infinity_layout);


        Money fifty_euro = new Money(200, (ImageView) findViewById(R.id.fifty_euro));
        Money twenty_euro = new Money(80, (ImageView) findViewById(R.id.twenty_euro));
        Money ten_dollar = new Money(35, (ImageView) findViewById(R.id.ten_dollar));
        Money ten_euro = new Money(40, (ImageView) findViewById(R.id.ten_euro));
        Money twenty_shekels = new Money(20, (ImageView) findViewById(R.id.twenty_shekels));
        Money fifty_shekels = new Money(50, (ImageView) findViewById(R.id.fifty_shekels));
        Money twenty_dollars = new Money(70, (ImageView) findViewById(R.id.twenty_dollars));
        Money one_hundread_shekels = new Money(100, (ImageView) findViewById(R.id.one_hundread_shekels));

        final CashRegister cash_register = new CashRegister((ImageView) findViewById(R.id.cash_register));
        final TextView cash_register_view = (TextView) findViewById(R.id.cash_register_sum);
        final TextView Score_view = (TextView) findViewById(R.id.score_view);
        CountDownCounter = (TextView) findViewById(R.id.timerTextView);


        int final_target_number = get_next_target_number();
        final TargetNumber target_Number = new TargetNumber(final_target_number, (TextView) findViewById(R.id.target_number), 999);
        min_clicks_to_reach_target_number = minimum_touches_to_reach_the_target_numnber(final_target_number);

        Log.d("minimum clicks", "minimum clicks = " + String.valueOf(min_clicks_to_reach_target_number));

        long start_play_time = 16000;
        start_timer(CountDownCounter, start_play_time);

        ImageButton reset_cash_register_button = (ImageButton) findViewById(R.id.reset_cash_register_sum);
        reset_cash_register(reset_cash_register_button, cash_register, cash_register_view);


        MoveMoeny(cash_register, fifty_euro, cash_register_view, target_Number, Score_view);
        MoveMoeny(cash_register, twenty_euro, cash_register_view, target_Number, Score_view);
        MoveMoeny(cash_register, ten_dollar, cash_register_view, target_Number, Score_view);
        MoveMoeny(cash_register, ten_euro, cash_register_view, target_Number, Score_view);
        MoveMoeny(cash_register, twenty_shekels, cash_register_view, target_Number, Score_view);
        MoveMoeny(cash_register, fifty_shekels, cash_register_view, target_Number, Score_view);
        MoveMoeny(cash_register, twenty_dollars, cash_register_view, target_Number, Score_view);
        MoveMoeny(cash_register, one_hundread_shekels, cash_register_view, target_Number, Score_view);

    }

    public void reached_to_target_number(final TargetNumber target_Number, final CashRegister cash_register, final TextView cash_register_view) {
        stop_timer();
        time_play -= 500;
        start_timer(CountDownCounter, time_play);
        cash_register.reset_sum();
        cash_register_view.setText("0");

        score += get_target_score();
        Log.d("score", "score = " + String.valueOf(score));
        set_next_targer_number(target_Number);
        min_clicks_to_reach_target_number = minimum_touches_to_reach_the_target_numnber(target_Number.get_Target_number());
        Log.d("minimum clicks", "minimum clicks = " + String.valueOf(min_clicks_to_reach_target_number));
        sec_to_reach_target_number = 0;
    }

    //replace the target number to new one;
    public void set_next_targer_number(TargetNumber target_Number) {

        int final_target_number = get_next_target_number();
        target_Number.set_Target_number(final_target_number);

    }

    public int get_next_target_number() {
        int target_number = 0;
        Random random = new Random();
        List<Integer> cash_values = Arrays.asList(80, 50, 20, 35, 40, 70, 100);

        for (Integer bill_value : cash_values) {
            int random_number = random.nextInt(3);
            target_number += random_number * bill_value;
        }
        return target_number;
    }

    //return the minimum times that cash needs to enter the safebox to reach the target number;
    @SuppressLint("NewApi")
    public int minimum_touches_to_reach_the_target_numnber(int targetNumber) {
        int counter = 0;
        double [] dead_end_numbers = {10.0,30.0};
        List<Integer> cash_values = Arrays.asList(200, 100, 80, 70,50, 40, 35, 20);

        if (targetNumber % 10 == 5){
            targetNumber -= 35;
            counter += 1;
        }

        for (Integer bill_value: cash_values){
            if (bill_value <= targetNumber){
                double module = targetNumber % bill_value;
                if (DoubleStream.of(dead_end_numbers).noneMatch(x -> x==module)){
                    int bill_counter = targetNumber / bill_value;
                    targetNumber -= bill_counter * bill_value;
                    Log.d("target number", "target number= " + String.valueOf(targetNumber));
                    Log.d("target number", String.format("%d used %d", bill_value, bill_counter));
                    counter += bill_counter;
                }
            }
            if (targetNumber == 0)
                return counter;
        }
        return counter;
    }
}


