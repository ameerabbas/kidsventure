package com.example.unais.kidsventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class secondTrans extends AppCompatActivity {

    public ImageView soundimg, imvbck, imvnxt;
    public TextView tvanswer;
    public Button bt1, bt2;

    public void thirdtrans(){
        imvnxt= (ImageView)findViewById(R.id.imvnxt);
        imvnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transthird = new Intent(secondTrans.this, thirdTrans.class);
                startActivity(transthird);
            }
        });
    }

    public void backtofrst(){
        imvbck=(ImageView)findViewById(R.id.imvbck);
        imvbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frstbck = new Intent(secondTrans.this, firstScreen.class);
                startActivity(frstbck);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_trans);
        thirdtrans();
        backtofrst();
        soundimg=(ImageView)findViewById(R.id.soundimg);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.train);
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
        bt2=(Button)findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText("Correct answer :)");

            }
        });

    }
}
