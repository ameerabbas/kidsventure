package com.example.unais.kidsventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class secondAni extends AppCompatActivity {

    public ImageView soundimg, imlion, imdog;
    public ImageView imnxt;
    public ImageView imbck;
    public TextView tvanswer, tv1, tv2;
    public Button bt1, bt2;

    public void thirdani(){
        imnxt = (ImageView) findViewById(R.id.imnxt);
        imnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anithird = new Intent(secondAni.this, thirdact.class);
                startActivity(anithird);
            }
        });
    }

    public void bcktofirst(){
        imbck=(ImageView) findViewById(R.id.imbck);
        imbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bckfirst = new Intent(secondAni.this, firstScreen.class);
                startActivity(bckfirst);

                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_ani);
        thirdani();
        bcktofirst();
        soundimg = (ImageView) findViewById(R.id.soundimg);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.lion);
        soundimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        tvanswer = (TextView) findViewById(R.id.tvnswer);
        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText("Correct answer :)");
            }
        });
        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText("Incorrect answer :(");
            }
        });
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }
}
