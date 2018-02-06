package com.example.unais.kidsventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class secInst extends AppCompatActivity {

    public ImageView soundimg, imvback, imvnext, imviolin, impiano;
    public TextView tvanswer, tv1, tv2;
    public Button bt1, bt2;

    public void thirdinst(){
        imvnext=(ImageView)findViewById(R.id.imvnext);
        imvnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instthird = new Intent(secInst.this, thirdInst.class);
                startActivity(instthird);
            }
        });
    }

    public void bckfrst(){
        imvback=(ImageView)findViewById(R.id.imvback);
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frstback = new Intent(secInst.this, firstScreen.class);
                startActivity(frstback);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_inst);
        thirdinst();
        bckfrst();
        soundimg = (ImageView)findViewById(R.id.soundimg);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.violin);
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
                tvanswer.setText("Correct answer :)");
            }
        });
        bt2=(Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText("Incorrect answer :(");
            }
        });
        tv1=(TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText("Correct answer :)");
            }
        });
        tv2=(TextView) findViewById(R.id.tv2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText("Incorrect answer :(");
            }
        });
    }
}

