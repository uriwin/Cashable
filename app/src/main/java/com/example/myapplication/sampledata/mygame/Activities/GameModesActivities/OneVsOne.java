package com.example.myapplication.sampledata.mygame.Activities.GameModesActivities;

import android.os.Bundle;
import android.os.CountDownTimer;
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


public class OneVsOne extends BasicGame {
    private float xCoOrdinate, yCoOrdinate;
    private int minimum_clicks, score_player_1, score_player_2;
    private long sec_to_reach_target_number = 0;
    private long timeRemaining = 60000;
    private CountDownTimer ct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_vs_one_layout);

        //for both players
        int final_target_number = get_random_number(199);
        minimum_clicks = minimum_touches_to_reach_the_target_numnber(final_target_number);

        final TextView CountDownCounter = (TextView) findViewById(R.id.timerTextView);
        final TextView CountDownCounter_player2 = (TextView) findViewById(R.id.timerTextView_player2);

        start_timer(CountDownCounter, CountDownCounter_player2);
        ct.start();


        //player 1
        int player = 1;
        Money one_shekel_player_1 = new Money(1, (ImageView) findViewById(R.id.one_shekel_player1));
        Money two_shekels_player_1 = new Money(2, (ImageView) findViewById(R.id.two_shekels_player1));
        Money five_shekels_player_1 = new Money(5, (ImageView) findViewById(R.id.five_sheksels_player1));
        Money ten_shekels_player_1 = new Money(10, (ImageView) findViewById(R.id.ten_shekels_player1));
        Money twenty_shekels_player_1 = new Money(20, (ImageView) findViewById(R.id.twenty_shekels_player1));
        Money fifty_shekels_player_1 = new Money(50, (ImageView) findViewById(R.id.fifty_shekels_player1));

        final CashRegister cash_register_player_1 = new CashRegister((ImageView) findViewById(R.id.cash_register_player1));
        final TextView cash_register_view_player_1 = (TextView) findViewById(R.id.cash_register_sum_player1);
        final TextView Score_view_player_1 = (TextView) findViewById(R.id.score_view_player1);
        final TargetNumber target_Number_player_1 = new TargetNumber(final_target_number, (TextView) findViewById(R.id.target_number_player1), 199);

        ImageButton reset_player_1 = (ImageButton) findViewById(R.id.reset_cash_register_sum_player1);

        reset_player_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cash_register_player_1.reset_sum();
                cash_register_view_player_1.setText(String.valueOf(cash_register_player_1.get_sum()));
            }
        });


        // player 2
        player = 2;
        Money one_shekel_player_2 = new Money(1, (ImageView) findViewById(R.id.one_shekel_player2));
        Money two_shekels_player_2 = new Money(2, (ImageView) findViewById(R.id.two_shekels_player2));
        Money five_shekels_player_2 = new Money(5, (ImageView) findViewById(R.id.five_sheksels_player2));
        Money ten_shekels_player_2 = new Money(10, (ImageView) findViewById(R.id.ten_shekels_player2));
        Money twenty_shekels_player_2 = new Money(20, (ImageView) findViewById(R.id.twenty_shekels_player2));
        Money fifty_shekels_player_2 = new Money(50, (ImageView) findViewById(R.id.fifty_shekels_player2));

        final CashRegister cash_register_player_2 = new CashRegister((ImageView) findViewById(R.id.cash_register_player2));
        final TextView cash_register_view_player_2 = (TextView) findViewById(R.id.cash_register_sum_player2);
        final TextView Score_view_player_2 = (TextView) findViewById(R.id.score_view_player2);
        final TargetNumber target_Number_player_2 = new TargetNumber(final_target_number, (TextView) findViewById(R.id.target_number_player2), 199);


        ImageButton reset_player_2 = (ImageButton) findViewById(R.id.reset_cash_register_sum_player2);

        reset_player_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cash_register_player_2.reset_sum();
                cash_register_view_player_2.setText(String.valueOf(cash_register_player_2.get_sum()));
            }
        });


        MoveMoeny(cash_register_player_1, one_shekel_player_1, cash_register_view_player_1, target_Number_player_1, Score_view_player_1, player, cash_register_player_2, target_Number_player_2, cash_register_view_player_2);
        MoveMoeny(cash_register_player_1, two_shekels_player_1, cash_register_view_player_1, target_Number_player_1, Score_view_player_1, player, cash_register_player_2, target_Number_player_2, cash_register_view_player_2);
        MoveMoeny(cash_register_player_1, five_shekels_player_1, cash_register_view_player_1, target_Number_player_1, Score_view_player_1, player, cash_register_player_2, target_Number_player_2, cash_register_view_player_2);
        MoveMoeny(cash_register_player_1, ten_shekels_player_1, cash_register_view_player_1, target_Number_player_1, Score_view_player_1, player, cash_register_player_2, target_Number_player_2, cash_register_view_player_2);
        MoveMoeny(cash_register_player_1, twenty_shekels_player_1, cash_register_view_player_1, target_Number_player_1, Score_view_player_1, player, cash_register_player_2, target_Number_player_2, cash_register_view_player_2);
        MoveMoeny(cash_register_player_1, fifty_shekels_player_1, cash_register_view_player_1, target_Number_player_1, Score_view_player_1, player, cash_register_player_2, target_Number_player_2, cash_register_view_player_2);

        MoveMoeny(cash_register_player_2, one_shekel_player_2, cash_register_view_player_2, target_Number_player_2, Score_view_player_2, player, cash_register_player_1, target_Number_player_1, cash_register_view_player_1);
        MoveMoeny(cash_register_player_2, two_shekels_player_2, cash_register_view_player_2, target_Number_player_2, Score_view_player_2, player, cash_register_player_1, target_Number_player_1, cash_register_view_player_1);
        MoveMoeny(cash_register_player_2, five_shekels_player_2, cash_register_view_player_2, target_Number_player_2, Score_view_player_2, player, cash_register_player_1, target_Number_player_1, cash_register_view_player_1);
        MoveMoeny(cash_register_player_2, ten_shekels_player_2, cash_register_view_player_2, target_Number_player_2, Score_view_player_2, player, cash_register_player_1, target_Number_player_1, cash_register_view_player_1);
        MoveMoeny(cash_register_player_2, twenty_shekels_player_2, cash_register_view_player_2, target_Number_player_2, Score_view_player_2, player, cash_register_player_1, target_Number_player_1, cash_register_view_player_1);
        MoveMoeny(cash_register_player_2, fifty_shekels_player_2, cash_register_view_player_2, target_Number_player_2, Score_view_player_2, player, cash_register_player_1, target_Number_player_1, cash_register_view_player_1);

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


    // set each coin and bill on touch listner;
    public void MoveMoeny(final CashRegister cash_register, final Money money, final TextView cash_register_view, final TargetNumber target_Number, final TextView Score_view, final int player, final CashRegister enemy_cash_register, final TargetNumber enemy_target_number, final TextView enemy_cash_register_view) {
        money.get_image().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - event.getRawX();
                        yCoOrdinate = view.getY() - event.getRawY();

                        money.set_default_X(view.getLeft());
                        money.set_default_Y(view.getTop());

                        cash_register.set_accessible(true);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();

                        break;
                    case MotionEvent.ACTION_UP:
                        if (money_in_bounds_of_CashRegister(cash_register, money.get_image())) {
                            if (cash_register.get_accessible()) {
                                add_money_to_cash_register(money, cash_register, cash_register_view);
                                if (cash_register.get_sum() == target_Number.get_Target_number()) {
                                    reached_to_target_number(target_Number, cash_register, cash_register_view, player, enemy_cash_register, enemy_target_number, enemy_cash_register_view);
                                    if (player == 1)
                                        Score_view.setText(String.valueOf(score_player_1));
                                    else
                                        Score_view.setText(String.valueOf(score_player_2));
                                }
                            }
                        }
                        view.animate().x(money.get_default_X()).y(money.get_default_Y()).setDuration(0).start();

                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }


    public void reached_to_target_number(final TargetNumber target_Number, final CashRegister cash_register, final TextView cash_register_view, int player, final CashRegister enemy_cash_register, final TargetNumber enemy_target_number, final TextView enemy_cash_register_view) {
        cash_register.reset_sum();
        enemy_cash_register.reset_sum();
        cash_register_view.setText("0");
        enemy_cash_register_view.setText("0");

        minimum_clicks = minimum_touches_to_reach_the_target_numnber(target_Number.get_Target_number());
        Log.d("minimum clicks", "minimum clicks = " + String.valueOf(minimum_clicks));

        if (player == 1) {
            score_player_1 += get_target_score();
        } else {
            score_player_2 += get_target_score();
        }
        sec_to_reach_target_number = 0;
        set_next_targer_number(target_Number, enemy_target_number);

    }

    //replace the target number to new one;

    public void set_next_targer_number(TargetNumber target_Number_player1, TargetNumber target_Number_player2) {

        int final_target_number = get_random_number(target_Number_player1.get_max_target_number());
        target_Number_player1.set_Target_number(final_target_number);
        target_Number_player2.set_Target_number(final_target_number);

    }

}
