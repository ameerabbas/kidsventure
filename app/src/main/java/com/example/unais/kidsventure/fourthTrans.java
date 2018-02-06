package com.example.unais.kidsventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class fourthTrans extends AppCompatActivity {

    public ImageView soundimg, imvbck, imvnxt;
    public TextView tvanswer;
    public Button bt1, bt2;

    public void fifthtrans(){
        imvnxt= (ImageView)findViewById(R.id.imvnxt);
        imvnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transfifth = new Intent(fourthTrans.this, fifthTrans.class);
                startActivity(transfifth);
            }
        });
    }

    public void backtofrst(){
        imvbck=(ImageView)findViewById(R.id.imvbck);
        imvbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frstbck = new Intent(fourthTrans.this, firstScreen.class);
                startActivity(frstbck);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_trans);
        fifthtrans();
        backtofrst();
        soundimg=(ImageView)findViewById(R.id.soundimg);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.car);
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
        bt2=(Button)findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText("Incorrect answer :(");

            }
        });

    }
}
