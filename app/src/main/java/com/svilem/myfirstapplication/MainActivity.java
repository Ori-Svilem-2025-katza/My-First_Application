package com.svilem.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // הגדרת משתנים
    Button b1, b2, btnLINEAR, btungame, moveToActivity2Button, playButton;
    TextView tv1;
    ConstraintLayout lt;
    Switch switchcolor;

    MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // הגדרת המוזיקה והכפתור
        mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer.setLooping(true); // המוזיקה תרוץ בלולאה אם תרצה

        // הגדרת כפתור השמעה/הפסקה של המוזיקה
        playButton = findViewById(R.id.playButton);

        // פעולה כאשר לוחצים על כפתור
        playButton.setOnClickListener(v -> {
            if (!isPlaying) {
                mediaPlayer.start(); // התחל את המוזיקה
                isPlaying = true;
                playButton.setText("הפסק מוזיקה"); // שינויים בטקסט של הכפתור
            } else {
                mediaPlayer.pause(); // הפסק את המוזיקה
                isPlaying = false;
                playButton.setText("הפעל מוזיקה"); // שינוי טקסט הכפתור
            }
        });

        // הגדרת שאר הרכיבים
        intView();

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                // Handle Home action
                return true;
            case R.id.action_profile:
                // Handle Profile action
                return true;
            case R.id.action_settings:
                // Handle Settings action
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void intView() {
        // הגדרת כפתור והגדרותיו
        b1 = findViewById(R.id.button1);
        b1.setOnClickListener(view -> Toast.makeText(MainActivity.this, "W", Toast.LENGTH_SHORT).show());

        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(view -> Toast.makeText(MainActivity.this, "L", Toast.LENGTH_SHORT).show());

        tv1 = findViewById(R.id.textView);
        lt = findViewById(R.id.main);
        switchcolor = findViewById(R.id.my_switch);

        // כפתור שמעביר לפעילות לינארית
        btnLINEAR = findViewById(R.id.butnLisner);
        btnLINEAR.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LinearActivity.class);
            startActivity(intent);
        });

        // כפתור שמעביר לפעילות משחק
        btungame = findViewById(R.id.btungame);
        btungame.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });

        // כפתור שמעביר לפעילות שנייה
        moveToActivity2Button = findViewById(R.id.moveToActivity2Button);
        moveToActivity2Button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // שחרור המשאבים של ה- MediaPlayer
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
