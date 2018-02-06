package com.example.unais.kidsventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class firstScreen extends AppCompatActivity {


    public ImageView animalimg, instimg, transimg;

    public void secani(){
        animalimg = (ImageView)findViewById(R.id.animalimg);
        animalimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anisec = new Intent(firstScreen.this, secondAni.class);
                startActivity(anisec);
            }
        });
    }

    public void secinst(){
        instimg = (ImageView)findViewById(R.id.instimg);
        instimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instsec = new Intent(firstScreen.this, secInst.class);
                startActivity(instsec);
            }
        });
    }

    public void sectrans(){
        transimg = (ImageView)findViewById(R.id.alphaimg);
        transimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transsec = new Intent(firstScreen.this, secondTrans.class);
                startActivity(transsec);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        secani();
        secinst();
        sectrans();
    }
}
