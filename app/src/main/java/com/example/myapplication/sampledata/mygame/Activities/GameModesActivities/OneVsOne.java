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
    int player_1 = 0;
    int player_2 = 1;
    Money[] player_one_money_objects;
    Money[] player_two_money_objects;
    TextView Score_view_player_1;
    ImageButton reset_button_player_1;
    TextView Score_view_player_2;
    ImageButton reset_button_player_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_vs_one_layout);

        cash_values = Arrays.asList(50, 20, 10, 5, 2, 1);

        reset_button_player_1 = findViewById(R.id.reset_cash_register_sum_player1);
        reset_button_player_2 = findViewById(R.id.reset_cash_register_sum_player2);

        initializer();
    }

    @Override
    protected void onStart() {
        super.onStart();

        cash_registers[player_1].reset_cash_register(reset_button_player_1, cash_registers_views[player_1]);
        cash_registers[player_2].reset_cash_register(reset_button_player_2, cash_registers_views[player_2]);

        timer.start_count_down_timer();

        MoveMoney(cash_registers, player_one_money_objects, cash_registers_views, target_numbers, Score_view_player_1, player_1);
        MoveMoney(cash_registers, player_two_money_objects, cash_registers_views, target_numbers, Score_view_player_2, player_2);
    }

    private void initialize_money_objects() {
        int[] money_objects_value = new int[]{1, 2, 5, 10, 20, 50};

        ImageView[] player_one_money_objects_view = new ImageView[]{findViewById(R.id.one_shekel_player1), findViewById(R.id.two_shekels_player1), findViewById(R.id.five_sheksels_player1),
                findViewById(R.id.ten_shekels_player1), findViewById(R.id.twenty_shekels_player1), findViewById(R.id.fifty_shekels_player1)};

        ImageView[] player_two_money_objects_view = new ImageView[]{findViewById(R.id.one_shekel_player2), findViewById(R.id.two_shekels_player2), findViewById(R.id.five_sheksels_player2),
                findViewById(R.id.ten_shekels_player2), findViewById(R.id.twenty_shekels_player2), findViewById(R.id.fifty_shekels_player2)};

        player_one_money_objects = get_money_objects(money_objects_value, player_one_money_objects_view);
        player_two_money_objects = get_money_objects(money_objects_value, player_two_money_objects_view);
    }

    private void initialize_timer() {
        count_down_views = new TextView[2];
        count_down_views[player_1] = (TextView) findViewById(R.id.timerTextView);
        count_down_views[player_2] = (TextView) findViewById(R.id.timerTextView_player2);

        long play_time = 60000;
        create_count_down_timer(play_time, count_down_views);
        timer = new Timer(count_down_timer);
    }

    private void initialize_cash_register() {
        cash_registers = new CashRegister[2];
        cash_registers_views = new TextView[2];
        cash_registers[player_1] = new CashRegister(findViewById(R.id.cash_register_player1));
        cash_registers_views[player_1] = findViewById(R.id.cash_register_sum_player1);
        cash_registers[player_2] = new CashRegister(findViewById(R.id.cash_register_player2));
        cash_registers_views[player_2] = findViewById(R.id.cash_register_sum_player2);
    }

    private void initialize_score() {
        players_score = new int[2];
        players_score[player_1] = 0;
        players_score[player_2] = 0;
        Score_view_player_1 = findViewById(R.id.score_view_player1);
        Score_view_player_2 = findViewById(R.id.score_view_player2);
    }

    private void initialize_target() {
        int final_target_number = get_random_number(199);
        target_numbers = new Target[2];
        target_numbers[player_1] = new Target(final_target_number, findViewById(R.id.target_number_player1), 199);
        target_numbers[player_2] = new Target(final_target_number, findViewById(R.id.target_number_player2), 199);
    }

    private void initializer(){
        initialize_target();
        initialize_score();
        initialize_cash_register();
        initialize_money_objects();
        initialize_timer();
    }

    @Override
    public void game_over() {
        finish();
    }
}
