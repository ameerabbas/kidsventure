package com.example.unais.kidsventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class thirdact extends AppCompatActivity {
    public ImageView soundimg, imlion, imdog;
    public ImageView imnxt;
    public ImageView imbck;
    public TextView tvanswer, tv1, tv2;
    public Button bt1, bt2;


    public void bcktofirst() {
        imbck = (ImageView) findViewById(R.id.imbck);
        imbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bckfirst = new Intent(thirdact.this, firstScreen.class);
                startActivity(bckfirst);

            }
        });
    }
    public void fourthani(){
        imnxt = (ImageView) findViewById(R.id.imnxt);
        imnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anifourth = new Intent(thirdact.this, fourthAni.class);
                startActivity(anifourth);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdact);
        fourthani();
        bcktofirst();
        soundimg = (ImageView)findViewById(R.id.soundimg);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.cow);
        soundimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        tvanswer=(TextView)findViewById(R.id.tvanswer);
        bt1=(Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText("Incorrect answer :(");
            }
        });
        bt2=(Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText("Correct answer :)");
            }
        });
        tv1=(TextView) findViewById(R.id.tv1);
        tv2=(TextView) findViewById(R.id.tv2);

    }
}


