package com.example.myapplication.sampledata.mygame.Activities.FrontPages;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Objects;

public class GameOverSoloMode extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_window);


        Button back_to_menu = findViewById(R.id.menu);
        Button play_again = findViewById(R.id.play_again);
        TextView score_view = findViewById(R.id.score_text);
        TextView highest_score = findViewById(R.id.higt_score_label);

        back_to_menu.setOnClickListener(view -> {
            Intent intent = new Intent(GameOverSoloMode.this, MainActivity.class);
            startActivity(intent);
        });

        play_again.setOnClickListener(view -> {
            Intent intent = new Intent(GameOverSoloMode.this, (Class<?>) get_previous_intent());
            startActivity(intent);
        });

        score_view.setText("SCORE: " + String.valueOf(get_score()));
        highest_score.setText("HIGHEST SCORE: " + String.valueOf(get_highest_score()));
    }

    private int get_score() {
        return Objects.requireNonNull(getIntent().getExtras()).getInt("score");
    }

    private Object get_previous_intent(){
        return Objects.requireNonNull(getIntent().getExtras()).get("activity mode intent");
    }

    private int get_highest_score(){
        return Objects.requireNonNull(getIntent().getExtras()).getInt("highest score");
    }


}
