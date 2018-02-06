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

public class SoundActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_menu);

        final ImageView imgAnimal = (ImageView) findViewById(R.id.SoundActivity_Animals);
        final ImageView imgMusicalInstruments = (ImageView) findViewById(R.id.SoundActivity_MusicalInstuments);
        final ImageView imgAlphabets = (ImageView) findViewById(R.id.SoundActivity_Alphabets);
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

        imgMusicalInstruments.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mp_pop_drip.start();
                imgMusicalInstruments.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Intent i = new Intent(getApplicationContext(), Counting.class);
                startActivity(i);
                finish();
                return false;


            }
        });
        imgAnimal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mp_pop_drip.start();
                imgAnimal.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Intent i = new Intent(getApplicationContext(), AnimalSounds.class);
                startActivity(i);
                finish();
                return false;


            }
        });
        imgAlphabets.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mp_pop_drip.start();
                imgAlphabets.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Intent i = new Intent(getApplicationContext(), SmallBig.class);
                startActivity(i);
                finish();
                return false;


            }
        });
    }

}
