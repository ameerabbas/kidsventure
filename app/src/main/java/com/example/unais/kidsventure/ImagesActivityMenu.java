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

public class ImagesActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_menu);
        final ImageView imgAnimal = (ImageView) findViewById(R.id.ImageActivity_Animals);
        final ImageView imgFruits = (ImageView) findViewById(R.id.ImageActivity_Fruits);
        final ImageView imgObject = (ImageView) findViewById(R.id.ImageActivity_Objects);
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

        imgAnimal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();

                imgAnimal.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Intent i = new Intent(getApplicationContext(), animalimg.class);
                startActivity(i);
                finish();
                return false;


            }
        });
        imgFruits.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();

                imgFruits.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Intent i = new Intent(getApplicationContext(), fruitsimg.class);
                startActivity(i);
                finish();
                return false;


            }
        });
        imgObject.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mp_pop_drip.start();
                imgObject.setBackgroundColor(Color.parseColor("#FFFFFF"));
                Intent i = new Intent(getApplicationContext(), objectimg.class);
                startActivity(i);
                finish();
                return false;


            }
        });


    }
}
