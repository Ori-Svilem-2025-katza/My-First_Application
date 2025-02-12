package com.svilem.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class resActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res2);

        Button btnAccept = findViewById(R.id.btnAccept);
        Button btnDecline = findViewById(R.id.btnDecline);

        // Set click listener for accept button
        btnAccept.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });

        // Set click listener for decline button
        btnDecline.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}