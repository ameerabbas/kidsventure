package com.example.unais.kidsventure;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectAvatar extends AppCompatActivity {

    int SelectedAvatar_id;


    private static ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecta_avatar);

        final ImageView imgAvatar1 = (ImageView) findViewById(R.id.avatar1);
        final ImageView imgAvatar2 = (ImageView) findViewById(R.id.avatar2);
        final ImageView imgAvatar3 = (ImageView) findViewById(R.id.avatar3);
        final ImageView imgAvatar4 = (ImageView) findViewById(R.id.avatar4);
        final ImageView imgAvatar5 = (ImageView) findViewById(R.id.avatar5);
        final ImageView imgAvatar6 = (ImageView) findViewById(R.id.avatar6);

//        final ImageView imgArrow = (ImageView) findViewById(R.id.arrowImg);

        final String DEFAULT_BG_COLOR = "#EDE331";
        final String BG_COLOR = "#EDE331";

        final ImageView NextBtn = (ImageView) findViewById(R.id.next);
        final MediaPlayer mp_pop_drip = MediaPlayer.create(this, R.raw.pop_drip);
        final MediaPlayer mp_tap = MediaPlayer.create(this, R.raw.tap);

        final ImageView SelectedAvatar = (ImageView) findViewById(R.id.selected_avatar);

        imgAvatar1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();
                SelectedAvatar_id = 1;

                imgAvatar1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                SelectedAvatar.setImageDrawable(getResources().getDrawable(getResourceID("avatar1", "drawable", getApplicationContext())));
                NextBtn.setImageDrawable(getResources().getDrawable(getResourceID("next", "drawable", getApplicationContext())));
                NextBtn.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove2));

                return false;
            }
        });
        imgAvatar2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();
                SelectedAvatar_id = 2;
                imgAvatar2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                SelectedAvatar.setImageDrawable(getResources().getDrawable(getResourceID("avatar2", "drawable", getApplicationContext())));
                NextBtn.setImageDrawable(getResources().getDrawable(getResourceID("next", "drawable", getApplicationContext())));
                NextBtn.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove2));
                return false;
            }
        });
        imgAvatar3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();
                SelectedAvatar_id = 3;
                imgAvatar3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                SelectedAvatar.setImageDrawable(getResources().getDrawable(getResourceID("avatar3", "drawable", getApplicationContext())));
                NextBtn.setImageDrawable(getResources().getDrawable(getResourceID("next", "drawable", getApplicationContext())));
                NextBtn.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove2));
                return false;
            }
        });
        imgAvatar4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();
                SelectedAvatar_id = 4;
                imgAvatar4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                SelectedAvatar.setImageDrawable(getResources().getDrawable(getResourceID("avatar4", "drawable", getApplicationContext())));
                NextBtn.setImageDrawable(getResources().getDrawable(getResourceID("next", "drawable", getApplicationContext())));
                NextBtn.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove2));
                return false;
            }
        });

        imgAvatar5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();
                SelectedAvatar_id = 5;
                imgAvatar5.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                SelectedAvatar.setImageDrawable(getResources().getDrawable(getResourceID("avatar5", "drawable", getApplicationContext())));
                NextBtn.setImageDrawable(getResources().getDrawable(getResourceID("next", "drawable", getApplicationContext())));
                NextBtn.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove2));

                return false;
            }
        });
        imgAvatar6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_pop_drip.start();
                SelectedAvatar_id = 6;
                imgAvatar6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                SelectedAvatar.setImageDrawable(getResources().getDrawable(getResourceID("avatar6", "drawable", getApplicationContext())));
                NextBtn.setImageDrawable(getResources().getDrawable(getResourceID("next", "drawable", getApplicationContext())));
                NextBtn.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove2));


                return false;
            }
        });

        // On Clicking Arrow

        NextBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_tap.start();
                NextBtn.setImageDrawable(getResources().getDrawable(getResourceID("nextclick", "drawable", getApplicationContext())));
                Intent i = new Intent(getApplicationContext(), LogoScreen.class);
                //i.putExtra("AVATAR_ID", SelectedAvatar_id);
                startActivity(i);
                finish();


                return false;


            }
        });}

    protected final static int getResourceID(final String resName, final String resType, final Context ctx)
    {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType, ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        }
        else
        {
            return ResourceID;
        }
    }

}
