package com.example.myapplication.sampledata.mygame.Activities.GameModesActivities;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.BasicGame;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.CashRegister;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Money;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.TargetNumber;


public class AgainstTime extends BasicGame {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.against_time_layout);

        //PlayGifView pGif = (PlayGifView) findViewById(R.id.pig_gif);
        //pGif.setImageResource(R.drawable.pig_gif2);
        int player_id = 0;
        players_score = new int [1];
        players_score[player_id] = 0;

        CashRegister [] cash_registers = new CashRegister[1];
        TextView [] cash_registers_views = new TextView[1];
        TargetNumber[] target_numbers = new TargetNumber[1];

        cash_registers[0] = new CashRegister((ImageView) findViewById(R.id.cash_register));
        cash_registers_views[0] = (TextView) findViewById(R.id.cash_register_sum);

        TextView CountDownCounter = (TextView) findViewById(R.id.timerTextView);
        TextView Score_view = (TextView) findViewById(R.id.score_view);

        int final_target_number = get_random_number(999);
        target_numbers[0] = new TargetNumber(final_target_number, (TextView) findViewById(R.id.target_number), 999);

        long start_play_time = 60000;
        start_timer(CountDownCounter, start_play_time);


        Money one_shekel = new Money(1, (ImageView) findViewById(R.id.one_shekel));
        Money two_shekels = new Money(2, (ImageView) findViewById(R.id.two_shekels));
        Money five_shekels = new Money(5, (ImageView) findViewById(R.id.five_sheksels));
        Money ten_shekels = new Money(10, (ImageView) findViewById(R.id.ten_shekels));
        Money twenty_shekels = new Money(20, (ImageView) findViewById(R.id.twenty_shekels));
        Money fifty_shekels = new Money(50, (ImageView) findViewById(R.id.fifty_shekels));
        Money two_hundread_shekels = new Money(200, (ImageView) findViewById(R.id.two_hundread_shekels));
        Money one_hundread_shekels = new Money(100, (ImageView) findViewById(R.id.one_hundread_shekels));


        ImageButton reset_cash_register_button = (ImageButton) findViewById(R.id.reset_cash_register_sum);
        reset_cash_register(reset_cash_register_button, cash_registers[0], cash_registers_views[0]);

        MoveMoney(cash_registers, one_shekel, cash_registers_views, target_numbers, Score_view, player_id);
        MoveMoney(cash_registers, two_shekels, cash_registers_views, target_numbers, Score_view, player_id);
        MoveMoney(cash_registers, five_shekels, cash_registers_views, target_numbers, Score_view, player_id);
        MoveMoney(cash_registers, ten_shekels, cash_registers_views, target_numbers, Score_view, player_id);
        MoveMoney(cash_registers, twenty_shekels, cash_registers_views, target_numbers, Score_view, player_id);
        MoveMoney(cash_registers, fifty_shekels, cash_registers_views, target_numbers, Score_view, player_id);
        MoveMoney(cash_registers, two_hundread_shekels, cash_registers_views, target_numbers, Score_view, player_id);
        MoveMoney(cash_registers, one_hundread_shekels, cash_registers_views, target_numbers, Score_view, player_id);
    }


}


