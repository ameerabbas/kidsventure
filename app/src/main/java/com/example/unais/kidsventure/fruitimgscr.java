package com.example.unais.kidsventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.unais.kidsventure.Counting.getResourceID;

public class fruitimgscr extends AppCompatActivity {

    private final int TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        final MediaPlayer mp_tap = MediaPlayer.create(this, R.raw.tap);

        int score = getIntent().getExtras().getInt("score");

        TextView textView = (TextView) findViewById(R.id.scoreText);
        textView.setText("" + score);

        final ImageView img_playagain = (ImageView) findViewById(R.id.playAgain);
        final ImageView img_mainmenu = (ImageView) findViewById(R.id.mainMenu);
        final ImageView img_comment = (ImageView) findViewById(R.id.comments);

        if(score < 1){
            img_comment.setImageDrawable(getResources().getDrawable(getResourceID("hardluck", "drawable", getApplicationContext())));
        }
        else{
            img_comment.setImageDrawable(getResources().getDrawable(getResourceID("yourscore", "drawable", getApplicationContext())));
        }
        final Handler handler = new Handler();
        final Handler handler2 = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                img_playagain.setImageDrawable(getResources().getDrawable(getResourceID("playagain", "drawable", getApplicationContext())));
                img_playagain.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove));
//
            }
        }, TIME_OUT);

        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {

                img_mainmenu.setImageDrawable(getResources().getDrawable(getResourceID("mainmenu", "drawable", getApplicationContext())));
                img_mainmenu.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove));
            }
        }, TIME_OUT+500);


        img_playagain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_tap.start();
                img_playagain.setImageDrawable(getResources().getDrawable(getResourceID("playagain_clicked", "drawable", getApplicationContext())));
                Intent i = new Intent(getApplicationContext(), fruitsimg.class);
                startActivity(i);

                return false;
            }
        });
        img_mainmenu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_tap.start();
                img_mainmenu.setImageDrawable(getResources().getDrawable(getResourceID("mainmenu_clicked", "drawable", getApplicationContext())));
                Intent i = new Intent(getApplicationContext(), ActivityMenu.class);
                startActivity(i);
                finish();

                return false;
            }
        });

    }
}

