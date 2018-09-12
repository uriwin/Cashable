package com.example.myapplication.sampledata.mygame.Activities.FrontPages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.R;

public class Levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        /*
        Button AdvenceToLevel_1= (Button)findViewById(R.id.button_1);
        AdvenceToLevel_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","1 Button was clicked");
                Intent intent = new Intent(Levels.this,AgainstTime.class);
                intent.putExtra("Level",1);
                startActivity(intent);
            }
        });
        */

    }

}
