package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.FrontPages.MainActivity;
import com.example.myapplication.sampledata.mygame.Activities.GameModesActivities.AgainstTime;

/**
 * Created by uri pc on 26/09/2017.
 */

public class ScoreAgainstTime extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_window);

        int final_score = getIntent().getIntExtra("Score",10);

        TextView score_text = (TextView)findViewById(R.id.score_text);
        TextView high_score = (TextView)findViewById(R.id.higt_score_label);

        score_text.setText(String.valueOf("Your score is: "+final_score));

        SharedPreferences settings = getSharedPreferences("GAME_DATA",Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE",0);

        if (final_score > highScore)
        {
            high_score.setText("High Score : "+ final_score);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE",final_score);
            editor.commit();
        }
        else
        {
            high_score.setText("High Score : "+ highScore);
        }



        Button AdvenceToAgainstTime= (Button)findViewById(R.id.against_time);
        AdvenceToAgainstTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","Levels Button was clicked");
                Intent intent = new Intent(ScoreAgainstTime.this,AgainstTime.class);
                startActivity(intent);
            }
        });


        Button AdvenceToMenu= (Button)findViewById(R.id.menu);
        AdvenceToMenu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Log.d("Botton Event", "Levels Button was clicked");
                Intent intent = new Intent(ScoreAgainstTime.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
