package com.example.myapplication.sampledata.mygame.Activities.GameModesActivities;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.BasicGame;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.CashRegister;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Money;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Target;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Timer;

import java.util.Arrays;


public class AgainstTime extends BasicGame {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.against_time_layout);

        //PlayGifView pGif = (PlayGifView) findViewById(R.id.pig_gif);
        //pGif.setImageResource(R.drawable.pig_gif2);
        int player_id = 0;
        players_score = new int[1];
        players_score[player_id] = 0;
        cash_values = Arrays.asList(200, 100, 50, 20, 10, 5, 2);

        CashRegister[] cash_registers = new CashRegister[1];
        TextView[] cash_registers_views = new TextView[1];
        Target[] target_numbers = new Target[1];
        TextView[] count_down_views = new TextView[1];

        cash_registers[player_id] = new CashRegister((ImageView) findViewById(R.id.cash_register));
        cash_registers_views[player_id] = (TextView) findViewById(R.id.cash_register_sum);

        count_down_views[player_id] = (TextView) findViewById(R.id.timerTextView);
        TextView Score_view = (TextView) findViewById(R.id.score_view);

        int final_target_number = get_random_number(999);
        target_numbers[player_id] = new Target(final_target_number, (TextView) findViewById(R.id.target_number), 999);


        int[] money_objects_value = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
        ImageView[] money_objects_view = new ImageView[]{findViewById(R.id.one_shekel), findViewById(R.id.two_shekels), findViewById(R.id.five_sheksels),
                findViewById(R.id.ten_shekels), findViewById(R.id.twenty_shekels), findViewById(R.id.fifty_shekels), findViewById(R.id.one_hundread_shekels), findViewById(R.id.two_hundread_shekels)};

        Money[] money_objects = get_money_objects(money_objects_value, money_objects_view);

        ImageButton reset_cash_register_button = (ImageButton) findViewById(R.id.reset_cash_register_sum);
        cash_registers[player_id].reset_cash_register(reset_cash_register_button, cash_registers_views[player_id]);

        long play_time = 60000;
        timer = new Timer(count_down_views, play_time);
        timer.create_count_down_timer();
        timer.start_count_down_timer();

        MoveMoney(cash_registers, money_objects, cash_registers_views, target_numbers, Score_view, player_id);
    }



}


