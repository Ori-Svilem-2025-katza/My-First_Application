package com.svilem.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int randomNum; // Store the random number generated

    private EditText inputMin;
    private EditText inputMax;
    private EditText inputNum;
    private boolean b = false;
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initialize views
        inputNum = findViewById(R.id.inputNum); // Input for user's guess
        inputMin = findViewById(R.id.inputMin); // Input for minimum value
        inputMax = findViewById(R.id.inputMax); // Input for maximum value

        // Buttons to trigger actions
        Button randomButton = findViewById(R.id.btunRandom); // Button to generate random number
        Button gameButton = findViewById(R.id.btunToTheGame); // Button to start the game

        // Set OnClickListener for the game button
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game(generateRandomNumber()); // Call Game method when clicked
            }
        });

        // Set OnClickListener for the random number button
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber(); // Call to generate random number
            }
        });
    }


    // Method to generate a random number within the specified range
    private int generateRandomNumber() {
        // Get the values entered by the user for min and max
        String minStr = inputMin.getText().toString();
        String maxStr = inputMax.getText().toString();

        // Validate that both values are entered
        if (minStr.isEmpty() || maxStr.isEmpty()) {
            Toast.makeText(this, "Please enter both minimum and maximum values.", Toast.LENGTH_SHORT).show();

        }

        // Convert the input strings to integers
        int min = Integer.parseInt(minStr);
        int max = Integer.parseInt(maxStr);

        // Validate that the minimum is less than the maximum
        if (min >= max) {
            Toast.makeText(this, "Minimum must be less than Maximum.", Toast.LENGTH_SHORT).show();

        }


        Random random = new Random();

        randomNum = random.nextInt(max - min + 1) + min;
        return randomNum;
    }


    private void Game(int randomNum) {

            String inputText = inputNum.getText().toString();
            if (inputText.isEmpty()) {
                Toast.makeText(this, "Please enter your guess.", Toast.LENGTH_SHORT).show();
                return;
            }


            int num = Integer.parseInt(inputText);

            if (randomNum == num) {
                Toast.makeText(this, "You guessed the number!", Toast.LENGTH_SHORT).show();
                Toast.makeText(this,"num of guess"+ count, Toast.LENGTH_SHORT).show();
            } else if (randomNum > num) {
                Toast.makeText(this, "Your number is too low", Toast.LENGTH_SHORT).show();
                count++;
                
            } else {
                Toast.makeText(this, "Your number is too high", Toast.LENGTH_SHORT).show();
                Game(randomNum);
                count++;

                }
                }
            }












