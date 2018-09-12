package com.example.myapplication.sampledata.mygame.Activities.GameModesActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.FrontPages.GameOverSoloMode;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.BasicGame;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.CashRegister;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Money;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Target;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Timer;

import java.util.Arrays;
import java.util.Random;


public class Infinity extends BasicGame {
    private long play_time = 16000;
    TextView[] count_down_views = new TextView[1];
    int player_id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infinity_layout);


        players_score = new int[1];
        players_score[player_id] = 0;
        cash_values = Arrays.asList(200, 100, 80, 70, 50, 40, 35, 20);


        CashRegister[] cash_registers = new CashRegister[1];
        TextView[] cash_registers_views = new TextView[1];
        Target[] target_numbers = new Target[1];

        cash_registers[player_id] = new CashRegister((ImageView) findViewById(R.id.cash_register));
        cash_registers_views[player_id] = (TextView) findViewById(R.id.cash_register_sum);
        final TextView Score_view = (TextView) findViewById(R.id.score_view);
        count_down_views[player_id] = (TextView) findViewById(R.id.timerTextView);

        int final_target_number = get_next_target_number();
        target_numbers[player_id] = new Target(final_target_number, (TextView) findViewById(R.id.target_number), 999);

        ImageButton reset_cash_register_button = (ImageButton) findViewById(R.id.reset_cash_register_sum);
        cash_registers[player_id].reset_cash_register(reset_cash_register_button, cash_registers_views[player_id]);

        int[] money_objects_value = new int[]{200, 80, 35, 40, 20, 50, 70, 100};
        ImageView[] money_objects_view = new ImageView[]{findViewById(R.id.fifty_euro), findViewById(R.id.twenty_euro), findViewById(R.id.ten_dollar),
                findViewById(R.id.ten_euro), findViewById(R.id.twenty_shekels), findViewById(R.id.fifty_shekels), findViewById(R.id.twenty_dollars), findViewById(R.id.one_hundread_shekels)};

        Money[] money_objects = get_money_objects(money_objects_value, money_objects_view);


        create_count_down_timer(play_time, count_down_views);
        timer = new Timer(count_down_timer);
        timer.start_count_down_timer();

        MoveMoney(cash_registers, money_objects, cash_registers_views, target_numbers, Score_view, player_id);
    }

    public void reached_to_target_number(Target[] targets_number, CashRegister[] cash_registers, TextView[] cash_registers_views, int player_id) {
        play_time -= 500;
        timer.cancel_count_down_timer();
        create_count_down_timer(play_time, count_down_views);
        timer.start_count_down_timer();

        set_score(targets_number, cash_registers, cash_registers_views, player_id);

        int next_target_number = get_next_target_number();
        set_target(targets_number, next_target_number);
        sec_to_reach_target_number = 0;
    }

    @Override
    public void game_over() {

        Intent intent = new Intent(Infinity.this,GameOverSoloMode.class);
        intent.putExtra("score", players_score[player_id]);
        intent.putExtra("activity mode intent", Infinity.class);
        startActivity(intent);
        finish();
    }

    public int get_next_target_number() {
        int target_number = 0;
        Random random = new Random();
        for (Integer bill_value : cash_values) {
            int random_number = random.nextInt(3);
            target_number += random_number * bill_value;
        }
        return target_number;
    }
}


