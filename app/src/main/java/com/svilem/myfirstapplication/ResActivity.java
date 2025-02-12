package com.svilem.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_TERMS_ACCEPTED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        Button btnAgreeTerms = findViewById(R.id.agreeButton);

        // Set click listener for agree button
        btnAgreeTerms.setOnClickListener(v -> {
            Intent intent = new Intent(ResActivity.this, resActivity2.class);
            startActivityForResult(intent, REQUEST_CODE_TERMS_ACCEPTED);
        });
    }

    // Handle result from TermsActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_TERMS_ACCEPTED) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "התקנון אושר!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "התקנון לא אושר.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
