package com.example.unais.kidsventure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.unais.kidsventure.Counting.getResourceID;

public class fifthAni extends AppCompatActivity {
    public ImageView imnxt;
    public ImageView imbck;
    public ImageView soundimg, imtiger, imsheep;
    public TextView tvanswer, tv1, tv2;
    public Button bt1, bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_ani);

        sixthani();
        bcktofirst();
        soundimg = (ImageView)findViewById(R.id.soundimg);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.tiger);
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
        tv2=(TextView) findViewById(R.id.tv2);
    }

    public void sixthani(){
        imnxt = (ImageView) findViewById(R.id.imnxt);
        imnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anisixth = new Intent(fifthAni.this, sixthAni.class);
                startActivity(anisixth);
            }
        });
    }

    public void bcktofirst(){
        imbck=(ImageView) findViewById(R.id.imbck);
        imbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent bckfirst = new Intent(fifthAni.this, firstScreen.class);
//                startActivity(bckfirst);

            }
        });
    }
    public void onButtonShowPopupWindowClick(String a, String b) {

        // get a reference to the already created main layout
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_counting);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        int height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, 0, 0, 0);
        //System.out.println("string:"+a);
//        final TextView rt = (TextView) popupView.findViewById(R.id.Result_text);
//        rt.setText(a);
        final ImageView ri = (ImageView) popupView.findViewById(R.id.Result_image1);
        ri.setImageDrawable(getResources().getDrawable(getResourceID(a, "drawable", getApplicationContext())));
        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                popupWindow.dismiss();
//                nextScreen();
//            }
//        }, 1000);}

//    public void nextScreen(){
//        final Handler handler1 = new Handler();
//        handler1.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                RandomImage();
//            }
//        }, TIME_OUT1);
//    }

}}
