package com.svilem.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, btnLINEAR, btungame, moveToActivity2Button;
    TextView tv1;
    ConstraintLayout lt;
    Switch switchcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intView();
    }

    private void intView() {
        b1 = findViewById(R.id.button1);
        b1.setOnClickListener(view -> Toast.makeText(MainActivity.this, "W", Toast.LENGTH_SHORT).show());

        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(view -> Toast.makeText(MainActivity.this, "L", Toast.LENGTH_SHORT).show());

        tv1 = findViewById(R.id.textView1);
        lt = findViewById(R.id.main);
        switchcolor = findViewById(R.id.my_switch);

        switchcolor.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                lt.setBackgroundColor(0xFFFF4C4C); // Red
            } else {
                lt.setBackgroundColor(0x8B0000); // Dark Red
            }
        });

        btnLINEAR = findViewById(R.id.butnLisner);
        btnLINEAR.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LinearActivity.class);
            startActivity(intent);
        });

        btungame = findViewById(R.id.btungame);
        btungame.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });

        moveToActivity2Button = findViewById(R.id.moveToActivity2Button);
        moveToActivity2Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}
