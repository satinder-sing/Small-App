package com.example.smallapp.main.basic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smallapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnProceed = findViewById(R.id.button); // Replace 'button' with your actual button ID
        EditText player1Name = findViewById(R.id.editTextText);
        EditText player2Name = findViewById(R.id.editTextText2);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);




        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1 = player1Name.getText().toString();
                String p2 = player2Name.getText().toString();
                if ((player2Name.getText().toString().trim().isEmpty())|| (player1Name.getText().toString().trim().isEmpty()))
                {
                    showToast("Please Enter Both Player Names");
                }
                else {
                    if (!p1.isEmpty() && !p2.isEmpty()){
                        intent.putExtra("player1",p1);
                        intent.putExtra("player2",p2);
                    }
                    startActivity(intent);
                }
            }
        });
    }
    private void showToast(String message) {
        // Show a toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}