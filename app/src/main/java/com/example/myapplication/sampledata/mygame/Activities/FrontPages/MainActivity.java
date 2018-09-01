package com.example.myapplication.sampledata.mygame.Activities.FrontPages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ImageButton AdvenceToLevels= (ImageButton)findViewById(R.id.levels);
        AdvenceToLevels.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","Levels Button was clicked");
                Intent intent = new Intent(MainActivity.this,Levels.class);
                startActivity(intent);
            }
        });
        */


        ImageButton AdvenceToModes= (ImageButton)findViewById(R.id.modes);
        AdvenceToModes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","Levels Button was clicked");
                Intent intent = new Intent(MainActivity.this,Modes.class);
                startActivity(intent);
            }
        });

        ImageButton AdvenceToInstructions= (ImageButton)findViewById(R.id.instructions);
        AdvenceToInstructions.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","Instructions= Button was clicked");
                Intent intent = new Intent(MainActivity.this,Instructions.class);
                startActivity(intent);
            }
        });

        ImageButton AdvenceToShop= (ImageButton)findViewById(R.id.shop);
        AdvenceToShop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","Shop Button was clicked");
                Intent intent = new Intent(MainActivity.this,Shop.class);
                startActivity(intent);
            }
        });

    }
}
