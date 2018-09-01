package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class BasicGame extends AppCompatActivity {
    private float xCoOrdinate, yCoOrdinate;
    private int min_clicks_to_reach_target_number;
    protected int score;
    protected CountDownTimer count_down_timer;
    protected long sec_to_reach_target_number = 0;

    public boolean money_in_bounds_of_CashRegister(CashRegister cash_register, ImageView image) {
        int cash_register_X_left = cash_register.getImage_view().getLeft();
        int cash_register_Y_up = cash_register.getImage_view().getTop();
        int cash_register_Y_down = (cash_register.getImage_view().getTop() + cash_register.getImage_view().getHeight());
        int cash_register_X_right = (cash_register.getImage_view().getLeft() + cash_register.getImage_view().getWidth());

        int centre_X_of_image = (int) (image.getX() + image.getWidth() / 2);
        int centre_Y_of_image = (int) (image.getY() + image.getHeight() / 2);

        if (cash_register_X_left < centre_X_of_image && centre_X_of_image < cash_register_X_right && cash_register_Y_up < centre_Y_of_image && cash_register_Y_down > centre_Y_of_image)
            return true;
        else if (cash_register_Y_up < (image.getY() + +image.getHeight()))
            return true;
        return false;


    }

    public void add_money_to_cash_register(Money money, CashRegister cash_register, TextView chash_register_view) {
        cash_register.add_money(money.get_value());
        Log.d("Cash Register Event", "enterd to the cashe register : " + String.valueOf(money.get_value()) + " money");
        Log.d("Cash Register Event", "cashe register have: " + String.valueOf(cash_register.get_sum()) + " money");

        chash_register_view.setText(String.valueOf(cash_register.get_sum()));
        cash_register.set_accessible(false);
    }


    public void start_timer(final TextView CountDownCounter, long play_time) {

        count_down_timer = new CountDownTimer(play_time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                CountDownCounter.setText(String.valueOf(millisUntilFinished / 1000));
                sec_to_reach_target_number += 1;

                if (10000 > millisUntilFinished) {
                    CountDownCounter.setBackgroundResource(R.drawable.clock_end_of_time);
                }
            }

            @Override
            public void onFinish() {
                CountDownCounter.setText(String.valueOf(0));
            }

        /*
        public void onFinish() {
            CountDownCounter.setText(String.valueOf(0));
            Intent intent = new Intent(AgainstTime.this, ScoreAgainstTime.class);
            intent.putExtra("Score", score);
            startActivity(intent);
        }
        */

        };
        count_down_timer.start();
    }

    public void stop_timer()

    {
        count_down_timer.cancel();
    }

    public void MoveMoeny(final CashRegister cash_register, final Money money, final TextView chash_register_view, final TargetNumber target_Number, final TextView Score_view) {
        money.get_image().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        motion_event_pressed(view, money, event, cash_register);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                        break;
                    case MotionEvent.ACTION_UP:
                        motion_event_realesed(cash_register, money, chash_register_view, target_Number, Score_view);
                        view.animate().x(money.get_default_X()).y(money.get_default_Y()).setDuration(0).start();
                        break;
                }
                return true;
            }
        });
    }

    public void motion_event_pressed(View view, Money money, MotionEvent event, CashRegister cash_register) {
        Log.d("motion event", "money view was pressed");
        xCoOrdinate = view.getX() - event.getRawX();
        yCoOrdinate = view.getY() - event.getRawY();

        money.set_default_X(view.getLeft());
        money.set_default_Y(view.getTop());

        cash_register.set_accessible(true);
    }

    public void motion_event_realesed(CashRegister cash_register, Money money, TextView chash_register_view, TargetNumber target_Number, TextView Score_view) {
        if (money_in_bounds_of_CashRegister(cash_register, money.get_image())) {
            if (cash_register.get_accessible()) {
                add_money_to_cash_register(money, cash_register, chash_register_view);
                if (cash_register.get_sum() == target_Number.get_Target_number()) {
                    reached_to_target_number(target_Number, cash_register, chash_register_view);
                    Score_view.setText(String.valueOf(score));
                }
            }
        }
    }

    public void reached_to_target_number(final TargetNumber target_Number, final CashRegister cash_register, final TextView chash_register_view) {

        cash_register.reset_sum();
        chash_register_view.setText("0");

        min_clicks_to_reach_target_number = minimum_touches_to_reach_the_target_numnber(target_Number.get_Target_number());
        Log.d("minimum clicks", "minimum clicks = " + String.valueOf(min_clicks_to_reach_target_number));

        score += get_target_score();
        Log.d("score", "score = " + String.valueOf(score));
        set_next_targer_number(target_Number);
        sec_to_reach_target_number = 0;
    }


    public void set_next_targer_number(TargetNumber target_Number) {

        int final_target_number = get_random_number(target_Number.get_max_target_number());
        target_Number.set_Target_number(final_target_number);
        Log.d("target number", "target numner: " + String.valueOf(final_target_number));

    }

    //return random number between 100-999;
    public int get_random_number(int max_random_number) {
        int min_random_number = 1;
        Random random = new Random();
        return (min_random_number + random.nextInt(max_random_number - min_random_number));
    }

    //return the minimum times that cash needs to enter the safebox to reach the target number;
    public int minimum_touches_to_reach_the_target_numnber(int targetNumner) {
        int counter = 0;
        List<Integer> cash_values = Arrays.asList(200, 100, 50, 20, 10, 5, 2);

        for (Integer bill_value : cash_values) {
            if (targetNumner / bill_value != 0) {

                int bill_counter = targetNumner / bill_value;
                targetNumner -= bill_counter * bill_value;
                counter += bill_counter;
            }
        }
        if (targetNumner == 0)
            return counter;

        counter += 1;
        return counter;
    }

    // add score whenever cash enters to the safe box;
    public int get_target_score() {
        double score_of_time = 175;
        double time_average = min_clicks_to_reach_target_number;
        Log.d("time", "time average to reach target number: " + String.valueOf(time_average));
        Log.d("time", "seconds to reach target number: " + String.valueOf(sec_to_reach_target_number));

        if (time_average >= sec_to_reach_target_number) {
            int less_time_then_needed = (int) Math.round(time_average - sec_to_reach_target_number);
            for (int i = 0; i < less_time_then_needed; i++) {
                score_of_time = score_of_time / 100 * 110;
            }
        } else {
            int more_time_then_needed = (int) Math.round(sec_to_reach_target_number - time_average);
            for (int i = 0; i < more_time_then_needed; i++) {
                score_of_time = score_of_time / 100 * 90;
            }
        }
        Log.d("score", "added to score: " + String.valueOf(score_of_time));
        return (int)score_of_time;


    }

    public void reset_cash_register(ImageButton reset_button, final CashRegister cash_register, final TextView cash_register_view) {

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cash_register.reset_sum();
                cash_register_view.setText(String.valueOf(cash_register.get_sum()));
            }
        });
    }


}

