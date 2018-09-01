package com.example.myapplication.sampledata.mygame.Activities.MoneyAppObjects;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.FrontPages.MainActivity;
import com.example.myapplication.sampledata.mygame.Activities.GameModesActivities.AgainstTime;

/**
 * Created by uri pc on 17/08/2017.
 */

public class Pause extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pause_window);
/*
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));
*/
        Button AdvenceToAgainstTimeRestart= (Button)findViewById(R.id.restart_against_time);
        AdvenceToAgainstTimeRestart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","Levels Button was clicked");
                Intent intent = new Intent(Pause.this,AgainstTime.class);
                startActivity(intent);
            }
        });


        Button AdvenceToMenu= (Button)findViewById(R.id.back_to_menu);
        AdvenceToMenu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Log.d("Botton Event", "Levels Button was clicked");
                Intent intent = new Intent(Pause.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button ResumeGame = (Button)findViewById(R.id.resume);
        ResumeGame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Log.d("Botton Event", "Resume Button was clicked");
                finish();
            }
        });
    }
}
