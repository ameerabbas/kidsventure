package com.example.unais.kidsventure;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlayScreen extends AppCompatActivity {

    private int PLAY_SCREEN_TIME_OUT = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(), SelectAvatar.class);
                startActivity(i);
                finish();

            }
        }, PLAY_SCREEN_TIME_OUT);


    }
}
