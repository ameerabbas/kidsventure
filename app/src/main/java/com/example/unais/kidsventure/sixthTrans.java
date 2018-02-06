package com.example.unais.kidsventure;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class sixthTrans extends AppCompatActivity {

    public ImageView soundimg, imvbck;
    public TextView tvanswer;
    public Button bt1, bt2;

    public void backtofrst(){
        imvbck=(ImageView)findViewById(R.id.imvbck);
        imvbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frstbck = new Intent(sixthTrans.this, firstScreen.class);
                startActivity(frstbck);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_trans);
        backtofrst();
        soundimg=(ImageView)findViewById(R.id.soundimg);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.boat);
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
