package com.example.myapplication.sampledata.mygame.Activities.GameModesActivities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.BasicGame;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.CashRegister;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Money;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.TargetNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;


public class Infinity extends BasicGame {
    private long play_time = 16000;
    TextView[] count_down_views = new TextView[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infinity_layout);

        int player_id = 0;
        players_score = new int[1];
        players_score[player_id] = 0;


        CashRegister[] cash_registers = new CashRegister[1];
        TextView[] cash_registers_views = new TextView[1];
        TargetNumber[] target_numbers = new TargetNumber[1];


        cash_registers[0] = new CashRegister((ImageView) findViewById(R.id.cash_register));
        cash_registers_views[0] = (TextView) findViewById(R.id.cash_register_sum);
        final TextView Score_view = (TextView) findViewById(R.id.score_view);
        count_down_views[player_id] = (TextView) findViewById(R.id.timerTextView);


        int final_target_number = get_next_target_number();
        target_numbers[0] = new TargetNumber(final_target_number, (TextView) findViewById(R.id.target_number), 999);

        start_timer(count_down_views, play_time);

        ImageButton reset_cash_register_button = (ImageButton) findViewById(R.id.reset_cash_register_sum);
        reset_cash_register(reset_cash_register_button, cash_registers[0], cash_registers_views[0]);

        int[] money_objects_value = new int[]{200, 80, 35, 40, 20, 50, 70, 100};
        ImageView[] money_objects_view = new ImageView[]{findViewById(R.id.fifty_euro), findViewById(R.id.twenty_euro), findViewById(R.id.ten_dollar),
                findViewById(R.id.ten_euro), findViewById(R.id.twenty_shekels), findViewById(R.id.fifty_shekels), findViewById(R.id.twenty_dollars), findViewById(R.id.one_hundread_shekels)};

        Money[] money_objects = new Money[8];
        for (int i = 0; i < money_objects.length; i++) {
            money_objects[i] = new Money(money_objects_value[i], money_objects_view[i]);
        }

        MoveMoney(cash_registers, money_objects, cash_registers_views, target_numbers, Score_view, player_id);
    }

    public void reached_to_target_number(TargetNumber[] targets_number, CashRegister[] cash_registers, TextView[] cash_registers_views, int player_id) {
        stop_timer();
        play_time -= 500;
        start_timer(count_down_views, play_time);

        set_score(targets_number, cash_registers, cash_registers_views, player_id);

        int next_target_number = get_next_target_number();
        set_target(targets_number, next_target_number);
        sec_to_reach_target_number = 0;
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
    public int minimum_touches_to_reach_the_target_number(int targetNumber) {
        int counter = 0;
        double[] dead_end_numbers = {10.0, 30.0};
        List<Integer> cash_values = Arrays.asList(200, 100, 80, 70, 50, 40, 35, 20);

        if (targetNumber % 10 == 5) {
            targetNumber -= 35;
            counter += 1;
        }

        for (Integer bill_value : cash_values) {
            if (bill_value <= targetNumber) {
                double module = targetNumber % bill_value;
                if (DoubleStream.of(dead_end_numbers).noneMatch(x -> x == module)) {
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


