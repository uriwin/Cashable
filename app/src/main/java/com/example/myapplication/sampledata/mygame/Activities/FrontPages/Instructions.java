package com.example.myapplication.sampledata.mygame.Activities.FrontPages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);


        ImageButton BackToManiPage= (ImageButton)findViewById(R.id.back_button);
        BackToManiPage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Log.d("Botton Event","Back To Menu Button was clicked");
                Intent intent = new Intent(Instructions.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
