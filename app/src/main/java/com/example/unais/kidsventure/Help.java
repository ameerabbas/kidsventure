package com.example.unais.kidsventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import static com.example.unais.kidsventure.Counting.getResourceID;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        final ImageView img_ok = (ImageView) findViewById(R.id.ok);
        final MediaPlayer mp_tap = MediaPlayer.create(this, R.raw.tap);
        //final int Avatar_ID = getIntent().getExtras().getInt("AVATAR_ID");

        img_ok.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_tap.start();
                img_ok.setImageDrawable(getResources().getDrawable(getResourceID("ok_clicked", "drawable", getApplicationContext())));
                Intent i = new Intent(getApplicationContext(), LogoScreen.class);
                //i.putExtra("AVATAR_ID", Avatar_ID);
                startActivity(i);
                //finish();
                return false;
            }
        });
    }
}
