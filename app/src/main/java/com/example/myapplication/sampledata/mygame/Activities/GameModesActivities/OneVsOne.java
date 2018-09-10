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


public class OneVsOne extends BasicGame {

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

        CashRegister[] cash_registers = new CashRegister[2];
        TextView[] cash_registers_views = new TextView[2];
        TargetNumber[] target_numbers = new TargetNumber[2];
        TextView[] count_down_views = new TextView[2];

        //player 1


        cash_registers[player_1] = new CashRegister((ImageView) findViewById(R.id.cash_register_player1));
        cash_registers_views[player_1] = (TextView) findViewById(R.id.cash_register_sum_player1);
        final TextView Score_view_player_1 = (TextView) findViewById(R.id.score_view_player1);
        target_numbers[player_1] = new TargetNumber(final_target_number, (TextView) findViewById(R.id.target_number_player1), 199);

        ImageButton reset_player_1 = (ImageButton) findViewById(R.id.reset_cash_register_sum_player1);
        reset_cash_register(reset_player_1, cash_registers[player_1], cash_registers_views[player_1]);


        // player 2

        cash_registers[player_2] = new CashRegister((ImageView) findViewById(R.id.cash_register_player2));
        cash_registers_views[player_2] = (TextView) findViewById(R.id.cash_register_sum_player2);
        final TextView Score_view_player_2 = (TextView) findViewById(R.id.score_view_player2);
        target_numbers[player_2] = new TargetNumber(final_target_number, (TextView) findViewById(R.id.target_number_player2), 199);

        ImageButton reset_player_2 = (ImageButton) findViewById(R.id.reset_cash_register_sum_player2);
        reset_cash_register(reset_player_2, cash_registers[player_2], cash_registers_views[player_2]);


        int[] money_objects_value = new int[]{1, 2, 5, 10, 20, 50};

        ImageView[] player_one_money_objects_view = new ImageView[]{findViewById(R.id.one_shekel_player1), findViewById(R.id.two_shekels_player1), findViewById(R.id.five_sheksels_player1),
                findViewById(R.id.ten_shekels_player1), findViewById(R.id.twenty_shekels_player1), findViewById(R.id.fifty_shekels_player1)};

        ImageView[] player_two_money_objects_view = new ImageView[]{findViewById(R.id.one_shekel_player2), findViewById(R.id.two_shekels_player2), findViewById(R.id.five_sheksels_player2),
                findViewById(R.id.ten_shekels_player2), findViewById(R.id.twenty_shekels_player2), findViewById(R.id.fifty_shekels_player2)};


        Money[] player_one_money_objects = new Money[6];
        for (int i = 0; i < player_one_money_objects.length; i++) {
            player_one_money_objects[i] = new Money(money_objects_value[i], player_one_money_objects_view[i]);
        }
        Money[] player_two_money_objects = new Money[6];
        for (int i = 0; i < player_two_money_objects.length; i++) {
            player_two_money_objects[i] = new Money(money_objects_value[i], player_two_money_objects_view[i]);
        }

        count_down_views[player_1] = (TextView) findViewById(R.id.timerTextView);
        count_down_views[player_2] = (TextView) findViewById(R.id.timerTextView_player2);

        long play_time = 60000;
        start_timer(count_down_views, play_time);

        MoveMoney(cash_registers, player_one_money_objects, cash_registers_views, target_numbers, Score_view_player_1, player_1);
        MoveMoney(cash_registers, player_two_money_objects, cash_registers_views, target_numbers, Score_view_player_2, player_2);
    }

}
