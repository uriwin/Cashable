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
        cash_values = Arrays.asList(50, 20, 10, 5, 2, 1);

        int final_target_number = get_random_number(199);

        CashRegister[] cash_registers = new CashRegister[2];
        TextView[] cash_registers_views = new TextView[2];
        Target[] target_numbers = new Target[2];
        TextView[] count_down_views = new TextView[2];

        //player 1
        cash_registers[player_1] = new CashRegister((ImageView) findViewById(R.id.cash_register_player1));
        cash_registers_views[player_1] = (TextView) findViewById(R.id.cash_register_sum_player1);
        final TextView Score_view_player_1 = (TextView) findViewById(R.id.score_view_player1);
        target_numbers[player_1] = new Target(final_target_number, (TextView) findViewById(R.id.target_number_player1), 199);

        ImageButton reset_button_player_1 = (ImageButton) findViewById(R.id.reset_cash_register_sum_player1);
        cash_registers[player_1].reset_cash_register(reset_button_player_1, cash_registers_views[player_1]);

        // player 2
        cash_registers[player_2] = new CashRegister((ImageView) findViewById(R.id.cash_register_player2));
        cash_registers_views[player_2] = (TextView) findViewById(R.id.cash_register_sum_player2);
        final TextView Score_view_player_2 = (TextView) findViewById(R.id.score_view_player2);
        target_numbers[player_2] = new Target(final_target_number, (TextView) findViewById(R.id.target_number_player2), 199);

        ImageButton reset_button_player_2 = (ImageButton) findViewById(R.id.reset_cash_register_sum_player2);
        cash_registers[player_2].reset_cash_register(reset_button_player_2, cash_registers_views[player_2]);

        int[] money_objects_value = new int[]{1, 2, 5, 10, 20, 50};

        ImageView[] player_one_money_objects_view = new ImageView[]{findViewById(R.id.one_shekel_player1), findViewById(R.id.two_shekels_player1), findViewById(R.id.five_sheksels_player1),
                findViewById(R.id.ten_shekels_player1), findViewById(R.id.twenty_shekels_player1), findViewById(R.id.fifty_shekels_player1)};

        ImageView[] player_two_money_objects_view = new ImageView[]{findViewById(R.id.one_shekel_player2), findViewById(R.id.two_shekels_player2), findViewById(R.id.five_sheksels_player2),
                findViewById(R.id.ten_shekels_player2), findViewById(R.id.twenty_shekels_player2), findViewById(R.id.fifty_shekels_player2)};

        Money[] player_one_money_objects = get_money_objects(money_objects_value, player_one_money_objects_view);
        Money[] player_two_money_objects = get_money_objects(money_objects_value, player_two_money_objects_view);

        count_down_views[player_1] = (TextView) findViewById(R.id.timerTextView);
        count_down_views[player_2] = (TextView) findViewById(R.id.timerTextView_player2);

        long play_time = 60000;
        timer = new Timer(count_down_views, play_time);
        timer.create_count_down_timer();
        timer.start_count_down_timer();

        MoveMoney(cash_registers, player_one_money_objects, cash_registers_views, target_numbers, Score_view_player_1, player_1);
        MoveMoney(cash_registers, player_two_money_objects, cash_registers_views, target_numbers, Score_view_player_2, player_2);
    }

}
