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

        ImageButton AdvenceToModes = (ImageButton) findViewById(R.id.modes);
        AdvenceToModes.setOnClickListener(view -> {
            Log.d("Botton Event", "Levels Button was clicked");
            Intent intent = new Intent(MainActivity.this, Modes.class);
            startActivity(intent);
        });

        ImageButton AdvenceToInstructions = (ImageButton) findViewById(R.id.instructions);
        AdvenceToInstructions.setOnClickListener(view -> {
            Log.d("Botton Event", "Instructions= Button was clicked");
            Intent intent = new Intent(MainActivity.this, Instructions.class);
            startActivity(intent);
        });

        ImageButton AdvenceToShop = (ImageButton) findViewById(R.id.shop);
        AdvenceToShop.setOnClickListener(view -> {
            Log.d("Botton Event", "Shop Button was clicked");
            Intent intent = new Intent(MainActivity.this, Shop.class);
            startActivity(intent);
        });

    }
}
