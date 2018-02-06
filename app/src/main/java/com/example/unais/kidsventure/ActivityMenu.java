package com.example.unais.kidsventure;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import static com.example.unais.kidsventure.SelectAvatar.getResourceID;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final MediaPlayer mp_tap = MediaPlayer.create(this, R.raw.tap);
//        String Avatar = "avatar" + getIntent().getExtras().getInt("AVATAR_ID");

        final ImageView imgSoundActivity = (ImageView) findViewById(R.id.SoundActivity);
        final ImageView imgImageActivity = (ImageView) findViewById(R.id.ImageActivity);
        final ImageView imgMathActivity = (ImageView) findViewById(R.id.MathActivity);
        //final ImageView imgAvatar = (ImageView) findViewById(R.id.Avatar);

        //imgAvatar.setImageDrawable(getResources().getDrawable(Counting.getResourceID(Avatar, "drawable", getApplicationContext())));
        final MediaPlayer mp_pop_drip = MediaPlayer.create(this, R.raw.pop_drip);
        final ImageView back_btn = (ImageView) findViewById(R.id.BackBtn);

        back_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_tap.start();
                back_btn.setImageDrawable(getResources().getDrawable(getResourceID("back_btn_clicked", "drawable", getApplicationContext())));
                Intent i = new Intent(getApplicationContext(), LogoScreen.class);
                startActivity(i);
                finish();

                return false;
            }
        });

        imgMathActivity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();
                imgMathActivity.setImageDrawable(getResources().getDrawable(getResourceID("math_activity_clicked", "drawable", getApplicationContext())));
//                imgMathActivity.setBackgroundColor(Color.parseColor("#c6f2ca"));
                Intent i = new Intent(getApplicationContext(), MathActivityMenu.class);
                startActivity(i);
                finish();
                return false;
            }
        });
        imgSoundActivity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();
                imgSoundActivity.setImageDrawable(getResources().getDrawable(getResourceID("sound_activity_clicked", "drawable", getApplicationContext())));

                Intent i = new Intent(getApplicationContext(), SoundActivityMenu.class);
                startActivity(i);
                finish();
                return false;
            }
        });
        imgImageActivity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();
                imgImageActivity.setImageDrawable(getResources().getDrawable(getResourceID("images_activity_clicked", "drawable", getApplicationContext())));
//                imgImageActivity.setBackgroundColor(Color.parseColor("#c6f2ca"));
                Intent i = new Intent(getApplicationContext(), ImagesActivityMenu.class);
                startActivity(i);
                finish();
                return false;
            }
        });
    }
}
