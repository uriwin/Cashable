package com.example.myapplication.sampledata.mygame.Activities.GameModesActivities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.BasicGame;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.CashRegister;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.Money;
import com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects.TargetNumber;


public class OneVsOne extends BasicGame {
    private float xCoOrdinate, yCoOrdinate;
    private int minimum_clicks;
    private long sec_to_reach_target_number = 0;
    private long timeRemaining = 60000;
    private CountDownTimer ct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_vs_one_layout);

        int player_1 = 0;
        int player_2 = 1;
        players_score = new int[2];
        players_score[player_1] = 0;
        players_score[player_2] = 0;

        //for both players
        int final_target_number = get_random_number(199);
//        minimum_clicks = minimum_touches_to_reach_the_target_number(final_target_number);

        final TextView CountDownCounter = (TextView) findViewById(R.id.timerTextView);
        final TextView CountDownCounter_player2 = (TextView) findViewById(R.id.timerTextView_player2);

        start_timer(CountDownCounter, CountDownCounter_player2);
        ct.start();

        CashRegister[] cash_registers = new CashRegister[2];
        TextView[] cash_registers_views = new TextView[2];
        TargetNumber[] target_numbers = new TargetNumber[2];
        //player 1

        Money one_shekel_player_1 = new Money(1, (ImageView) findViewById(R.id.one_shekel_player1));
        Money two_shekels_player_1 = new Money(2, (ImageView) findViewById(R.id.two_shekels_player1));
        Money five_shekels_player_1 = new Money(5, (ImageView) findViewById(R.id.five_sheksels_player1));
        Money ten_shekels_player_1 = new Money(10, (ImageView) findViewById(R.id.ten_shekels_player1));
        Money twenty_shekels_player_1 = new Money(20, (ImageView) findViewById(R.id.twenty_shekels_player1));
        Money fifty_shekels_player_1 = new Money(50, (ImageView) findViewById(R.id.fifty_shekels_player1));

        cash_registers[player_1] = new CashRegister((ImageView) findViewById(R.id.cash_register_player1));
        cash_registers_views[player_1] = (TextView) findViewById(R.id.cash_register_sum_player1);
        final TextView Score_view_player_1 = (TextView) findViewById(R.id.score_view_player1);
        target_numbers[player_1] = new TargetNumber(final_target_number, (TextView) findViewById(R.id.target_number_player1), 199);

        ImageButton reset_player_1 = (ImageButton) findViewById(R.id.reset_cash_register_sum_player1);
        reset_cash_register(reset_player_1, cash_registers[player_1], cash_registers_views[player_1]);


        // player 2
        Money one_shekel_player_2 = new Money(1, (ImageView) findViewById(R.id.one_shekel_player2));
        Money two_shekels_player_2 = new Money(2, (ImageView) findViewById(R.id.two_shekels_player2));
        Money five_shekels_player_2 = new Money(5, (ImageView) findViewById(R.id.five_sheksels_player2));
        Money ten_shekels_player_2 = new Money(10, (ImageView) findViewById(R.id.ten_shekels_player2));
        Money twenty_shekels_player_2 = new Money(20, (ImageView) findViewById(R.id.twenty_shekels_player2));
        Money fifty_shekels_player_2 = new Money(50, (ImageView) findViewById(R.id.fifty_shekels_player2));

        cash_registers[player_2] = new CashRegister((ImageView) findViewById(R.id.cash_register_player2));
        cash_registers_views[player_2] = (TextView) findViewById(R.id.cash_register_sum_player2);
        final TextView Score_view_player_2 = (TextView) findViewById(R.id.score_view_player2);
        target_numbers[player_2] = new TargetNumber(final_target_number, (TextView) findViewById(R.id.target_number_player2), 199);

        ImageButton reset_player_2 = (ImageButton) findViewById(R.id.reset_cash_register_sum_player2);
        reset_cash_register(reset_player_2, cash_registers[player_2], cash_registers_views[player_2]);


        MoveMoney(cash_registers, one_shekel_player_1, cash_registers_views, target_numbers, Score_view_player_1, player_1);
        MoveMoney(cash_registers, two_shekels_player_1, cash_registers_views, target_numbers, Score_view_player_1, player_1);
        MoveMoney(cash_registers, five_shekels_player_1, cash_registers_views, target_numbers, Score_view_player_1, player_1);
        MoveMoney(cash_registers, ten_shekels_player_1, cash_registers_views, target_numbers, Score_view_player_1, player_1);
        MoveMoney(cash_registers, twenty_shekels_player_1, cash_registers_views, target_numbers, Score_view_player_1, player_1);
        MoveMoney(cash_registers, fifty_shekels_player_1, cash_registers_views, target_numbers, Score_view_player_1, player_1);

        MoveMoney(cash_registers, one_shekel_player_2, cash_registers_views, target_numbers, Score_view_player_2, player_2);
        MoveMoney(cash_registers, two_shekels_player_2, cash_registers_views, target_numbers, Score_view_player_2, player_2);
        MoveMoney(cash_registers, five_shekels_player_2, cash_registers_views, target_numbers, Score_view_player_2, player_2);
        MoveMoney(cash_registers, ten_shekels_player_2, cash_registers_views, target_numbers, Score_view_player_2, player_2);
        MoveMoney(cash_registers, twenty_shekels_player_2, cash_registers_views, target_numbers, Score_view_player_2, player_2);
        MoveMoney(cash_registers, fifty_shekels_player_2, cash_registers_views, target_numbers, Score_view_player_2, player_2);

    }

    public void start_timer(final TextView CountDownCounter, final TextView CountDownCounter_player2) {

        ct = new CountDownTimer(timeRemaining, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                CountDownCounter.setText(String.valueOf(millisUntilFinished / 1000));
                CountDownCounter_player2.setText(String.valueOf(millisUntilFinished / 1000));
                sec_to_reach_target_number += 1;
                timeRemaining = millisUntilFinished;

                if (10000 > millisUntilFinished) {
                    CountDownCounter.setBackgroundResource(R.drawable.clock_end_of_time);
                    CountDownCounter_player2.setBackgroundResource(R.drawable.clock_end_of_time);
                }
            }


            public void onFinish() {
                CountDownCounter.setText(String.valueOf(0));
                CountDownCounter_player2.setText(String.valueOf(0));
                //Intent intent = new Intent(OneVsOne.this, ScoreAgainstTime.class);
                //intent.putExtra("Score", score);
                //startActivity(intent);
            }

        };
    }

}
