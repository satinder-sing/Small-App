package com.example.smallapp.main.basic;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smallapp.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Button[] buttons = new Button[9];  // Array to store buttons
    boolean isPlayerXTurn = true;  // True for player X, false for player O
    int turnCount = 0;  // Count number of turns
     String player1Name;
     String player2Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize buttons and set onClick listeners
        for (int i = 0; i < buttons.length; i++) {
            String buttonID = "btn" + (i + 1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resID);
            buttons[i].setOnClickListener(this);
        }
        Intent intent = getIntent();
        String player1 = intent.getStringExtra("player1");
        player1Name=player1;
        String player2 = intent.getStringExtra("player2");
        player2Name = player2;
        TextView playerNames = findViewById(R.id.textView2);
        if (player1!=null && player2!=null){
            playerNames.setText(player1.toString()+"  VS  "+player2.toString());}
        else {
            playerNames.setText("no names");
        }

    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;

        // Check if the button is already clicked
        if (!clickedButton.getText().toString().equals("")) {
            return;
        }

        // Set the text for the button and update the game state
        if (isPlayerXTurn) {
            clickedButton.setText("X");
        } else {
            clickedButton.setText("O");
        }

        turnCount++;
        isPlayerXTurn = !isPlayerXTurn;

        // Check for a winner
        if (checkForWinner()) {
            if (isPlayerXTurn) {
                showToast(player2Name +" wins!");
            } else {
                showToast(player1Name+" wins!");
            }
            resetGame();
        } else if (turnCount == 9) {
            // If all buttons are clicked and no winner, it's a draw
            showToast("It's a draw!");
            resetGame();
        }
    }

    private boolean checkForWinner() {
        String[][] field = new String[3][3];

        // Fill the field array with the button texts
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i * 3 + j].getText().toString();
            }
        }

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")) {
                return true;
            }
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")) {
                return true;
            }
        }

        // Check diagonals
        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")) {
            return true;
        }

        return false;  // No winner yet
    }

    private void resetGame() {
        // Reset the game state
        for (Button button : buttons) {
            button.setText("");
        }
        turnCount = 0;
        isPlayerXTurn = true;
    }

    private void showToast(String message) {
        // Show a toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}