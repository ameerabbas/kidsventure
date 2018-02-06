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

import static com.example.unais.kidsventure.Counting.getResourceID;

public class LogoScreen extends AppCompatActivity {
    private final int TIME_OUT = 300;
    //int SelectedAvatar_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_screen);
        final ImageView img_play = (ImageView) findViewById(R.id.play);
        final ImageView img_help = (ImageView) findViewById(R.id.help);
        final ImageView img_exit = (ImageView) findViewById(R.id.exit);
        //final ImageView imgAvatar = (ImageView) findViewById(R.id.Avatar);

        final MediaPlayer mp_tap = MediaPlayer.create(this, R.raw.tap);

//        String Avatar = "avatar" + getIntent().getExtras().getInt("AVATAR_ID");
//        imgAvatar.setImageDrawable(getResources().getDrawable(Counting.getResourceID(Avatar, "drawable", getApplicationContext())));



        img_play.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mp_tap.start();
                img_play.setImageDrawable(getResources().getDrawable(getResourceID("play_clicked", "drawable", getApplicationContext())));
                Intent i = new Intent(getApplicationContext(), ActivityMenu.class);
                startActivity(i);
                finish();
                return false;
            }
        });
        img_help.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mp_tap.start();
                img_help.setImageDrawable(getResources().getDrawable(getResourceID("help_clicked", "drawable", getApplicationContext())));
                Intent i = new Intent(getApplicationContext(), Help.class);
                //i.putExtra("AVATAR_ID", SelectedAvatar_id);
                startActivity(i);
                finish();
                return false;
            }
        });
        img_exit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_tap.start();
                img_exit.setImageDrawable(getResources().getDrawable(getResourceID("exit_clicked", "drawable", getApplicationContext())));
                finish();
                moveTaskToBack(true);

                return false;
            }
        });
        final Handler handler = new Handler();
        final Handler handler2 = new Handler();
        final Handler handler3 = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                img_play.setImageDrawable(getResources().getDrawable(getResourceID("play", "drawable", getApplicationContext())));
                img_play.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove));
//
            }
        }, TIME_OUT);

        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {

                img_help.setImageDrawable(getResources().getDrawable(getResourceID("help", "drawable", getApplicationContext())));
                img_help.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove));
            }
        }, TIME_OUT+400);

        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {

                img_exit.setImageDrawable(getResources().getDrawable(getResourceID("exit", "drawable", getApplicationContext())));
                img_exit.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove));
            }
        }, TIME_OUT+700);
    }
}
