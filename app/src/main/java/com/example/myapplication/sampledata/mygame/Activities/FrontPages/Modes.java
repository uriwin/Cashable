package com.example.myapplication.sampledata.mygame.Activities.FrontPages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.R;
import com.example.myapplication.sampledata.mygame.Activities.GameModesActivities.AgainstTime;
import com.example.myapplication.sampledata.mygame.Activities.GameModesActivities.Infinity;
import com.example.myapplication.sampledata.mygame.Activities.GameModesActivities.OneVsOne;

/**
 * Created by uri pc on 01/10/2017.
 */

public class Modes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modes_layout);

        ImageButton AdvenceToAgainstTime= (ImageButton)findViewById(R.id.against_time);
        AdvenceToAgainstTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","Against Time mode");
                Intent intent = new Intent(Modes.this,AgainstTime.class);
                startActivity(intent);
            }
        });

        ImageButton AdvenceToOneVSOne= (ImageButton)findViewById(R.id.two_players_mode);
        AdvenceToOneVSOne.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","One vs One mode");
                Intent intent = new Intent(Modes.this,OneVsOne.class);
                startActivity(intent);
            }
        });

        ImageButton AdvenceToInfinity= (ImageButton)findViewById(R.id.infinity_button);
        AdvenceToInfinity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","One vs One mode");
                Intent intent = new Intent(Modes.this,Infinity.class);
                startActivity(intent);
            }
        });


        ImageButton BackToMenu= (ImageButton)findViewById(R.id.back_to_menu);
        BackToMenu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event"," Back to menu");
                Intent intent = new Intent(Modes.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
