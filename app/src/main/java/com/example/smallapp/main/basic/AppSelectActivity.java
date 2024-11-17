package com.example.smallapp.main.basic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smallapp.R;

public class AppSelectActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedinstance) {
        super.onCreate(savedinstance);
        setContentView(R.layout.app_select_activity);
        Button buttonTicTacToe = findViewById(R.id.button2);
        Button buttonHitList = findViewById(R.id.button3);
        Intent intentTicTacToe = new Intent(AppSelectActivity.this, MainActivity.class);
        Intent intentHitList = new Intent(AppSelectActivity.this, KillNoteRecyclerActivity.class);

        buttonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentTicTacToe);
            }
        });
        buttonHitList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentHitList);
            }
        });
    }
}
