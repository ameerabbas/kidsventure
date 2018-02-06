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

public class MathActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_menu);

        final ImageView imgSum = (ImageView) findViewById(R.id.MathActivity_Sums);
        final ImageView imgCounting = (ImageView) findViewById(R.id.MathActivity_Counting);
        final ImageView imgSmallBig = (ImageView) findViewById(R.id.MathActivity_BigSmall);
        final MediaPlayer mp_pop_drip = MediaPlayer.create(this, R.raw.pop_drip);
        final MediaPlayer mp_tap = MediaPlayer.create(this, R.raw.tap);
        final ImageView back_btn = (ImageView) findViewById(R.id.BackBtn);

        back_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_tap.start();
                back_btn.setImageDrawable(getResources().getDrawable(getResourceID("back_btn_clicked", "drawable", getApplicationContext())));
                Intent i = new Intent(getApplicationContext(), ActivityMenu.class);
                startActivity(i);
                finish();

            return false;
            }
        });
        imgCounting.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mp_pop_drip.start();
                imgCounting.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Intent i = new Intent(getApplicationContext(), Counting.class);
                startActivity(i);
                finish();
                return false;


            }
        });
        imgSum.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mp_pop_drip.start();
                imgSum.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Intent i = new Intent(getApplicationContext(), Sums.class);
                startActivity(i);
                finish();
                return false;


            }
        });
        imgSmallBig.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mp_pop_drip.start();
                imgSmallBig.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Intent i = new Intent(getApplicationContext(), SmallBig.class);
                startActivity(i);
                finish();
                return false;


            }
        });

    }
}
