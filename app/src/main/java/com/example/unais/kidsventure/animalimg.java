package com.example.unais.kidsventure;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class animalimg extends AppCompatActivity {


    final Random rnd = new Random(System.currentTimeMillis());
    private static int TIME_OUT = 2000;
    private static int TIME_OUT1 = 1000;
    int SCORE = 0;
    int COUNT = 0;
    int LIMIT = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animalimg);
        final ImageView close_btn = (ImageView) findViewById(R.id.close_button);
        final MediaPlayer mp_tap = MediaPlayer.create(this, R.raw.tap);

        RandomImage();
        close_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_tap.start();
//                close_btn.setImageDrawable(getResources().getDrawable(getResourceID("close_clicked", "drawable", getApplicationContext())));
//                Intent i = new Intent(getApplicationContext(), ImagesActivityMenu.class);
//                startActivity(i);
//                finish();
                exitWindow();
                return false;
            }
        });
    }

    protected void RandomImage(){
        final MediaPlayer mp_correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer mp_wrong = MediaPlayer.create(this, R.raw.wrong);
        findViewById(R.id.option1).setBackgroundColor(0);
        findViewById(R.id.option2).setBackgroundColor(0);
        findViewById(R.id.option3).setBackgroundColor(0);

        final int rndnum = rnd.nextInt(10) + 1;

        String[] ans = {"cow","dog","elephant","fox","horse","mouse","parrot","pigeon","snake","sparrow"};
        final String answer = ans[rndnum-1];

        final ImageView img = (ImageView) findViewById(R.id.imgRandom);
        final ImageView opt1_img = (ImageView) findViewById(R.id.option1);
        final ImageView opt2_img = (ImageView) findViewById(R.id.option2);
        final ImageView opt3_img = (ImageView) findViewById(R.id.option3);

        final String str = "tag" + answer;
        img.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
        img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove));

        ArrayList image = new ArrayList();
        for (int j = 0; j < 10; j++) {
            image.add(ans[j]);
        }
        Collections.shuffle(image);
        ArrayList Num = new ArrayList();

        Num.add(answer);
        if (image.get(0) != Num.get(0)) {
            Num.add(image.get(0));
        }else if (image.get(1) != Num.get(0)) {
            Num.add(image.get(1));
        }else if (image.get(2) != Num.get(0)) {
            Num.add(image.get(2));
        }else if (image.get(3) != Num.get(0)) {
            Num.add(image.get(3));
        }else if (image.get(4) != Num.get(0)) {
            Num.add(image.get(4));
        }else if (image.get(5) != Num.get(0)) {
            Num.add(image.get(5));
        }else if (image.get(6) != Num.get(0)) {
            Num.add(image.get(6));
        }else if (image.get(7) != Num.get(0)) {
            Num.add(image.get(7));
        }else if (image.get(8) != Num.get(0)) {
            Num.add(image.get(8));
        }else if (image.get(9) != Num.get(0)) {
            Num.add(image.get(9));
        }
        if (image.get(0) != Num.get(1)&&image.get(0) != Num.get(0)) {
            Num.add(image.get(0));
        }else if (image.get(1) != Num.get(1)&&image.get(1) != Num.get(0)) {
            Num.add(image.get(1));
        }else if (image.get(2) != Num.get(1)&&image.get(2) != Num.get(0)) {
            Num.add(image.get(2));
        }else if (image.get(3) != Num.get(1)&&image.get(3) != Num.get(0)) {
            Num.add(image.get(3));
        }else if (image.get(4) != Num.get(1)&&image.get(4) != Num.get(0)) {
            Num.add(image.get(4));
        }else if (image.get(5) != Num.get(1)&&image.get(5) != Num.get(0)) {
            Num.add(image.get(5));
        }else if (image.get(6) != Num.get(1)&&image.get(6) != Num.get(0)) {
            Num.add(image.get(6));
        }else if (image.get(7) != Num.get(1)&&image.get(7) != Num.get(0)) {
            Num.add(image.get(7));
        }else if (image.get(8) != Num.get(1)&&image.get(8) != Num.get(0)) {
            Num.add(image.get(8));
        }else if (image.get(9) != Num.get(1)&&image.get(9) != Num.get(0)) {
            Num.add(image.get(9));
        }
        Collections.shuffle(Num);

        final String opt_str1 = "" + (Num.get(0));
        final String opt_str2 = "" + (Num.get(1));
        final String opt_str3 = "" + (Num.get(2));

        opt1_img.setImageDrawable(getResources().getDrawable(getResourceID(opt_str1, "drawable", getApplicationContext())));
        opt2_img.setImageDrawable(getResources().getDrawable(getResourceID(opt_str2, "drawable", getApplicationContext())));
        opt3_img.setImageDrawable(getResources().getDrawable(getResourceID(opt_str3, "drawable", getApplicationContext())));

        final String answer_img = answer;

        opt1_img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (getResources().getIdentifier(opt_str1, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                    opt1_img.setBackgroundColor(Color.parseColor("#00CC00"));
                    //tv.setText("CORRECT ANSWER!");
                    opt1_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                    opt2_img.setOnTouchListener(null);
                    opt3_img.setOnTouchListener(null);
                    mp_correct.start();
                    onButtonShowPopupWindowClick("correct", null);
                    SCORE++;
                } else {
                    opt1_img.setBackgroundColor(Color.parseColor("#EB3232"));
                    //tv.setText("WRONG ANSWER!");
                    //tv_ans.setText("Correct answer is " + answer);
                    opt1_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                    if (getResources().getIdentifier(opt_str1, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                        opt1_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom));
                        opt2_img.setOnTouchListener(null);
                        opt3_img.setOnTouchListener(null);
                    }
                    if (getResources().getIdentifier(opt_str2, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                        opt2_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom));
                        opt1_img.setOnTouchListener(null);
                        opt3_img.setOnTouchListener(null);
                    }
                    if (getResources().getIdentifier(opt_str3, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                        opt3_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom));
                        opt2_img.setOnTouchListener(null);
                        opt1_img.setOnTouchListener(null);
                    }
                    mp_wrong.start();
                    onButtonShowPopupWindowClick("wrong", "Correct answer is " + answer);
                }
                return false;
            }
        });

        opt2_img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (getResources().getIdentifier(opt_str2, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                    opt2_img.setBackgroundColor(Color.parseColor("#00CC00"));
                    //tv.setText("CORRECT ANSWER!");
                    opt2_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                    opt1_img.setOnTouchListener(null);
                    opt3_img.setOnTouchListener(null);
                    mp_correct.start();
                    onButtonShowPopupWindowClick("correct", null);
                    SCORE++;
                } else {
                    opt2_img.setBackgroundColor(Color.parseColor("#EB3232"));
                    //tv.setText("WRONG ANSWER!");
                    //tv_ans.setText("Correct answer is " + answer);
                    opt2_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                    if (getResources().getIdentifier(opt_str1, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                        opt1_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom));
                        opt2_img.setOnTouchListener(null);
                        opt3_img.setOnTouchListener(null);
                    }
                    if (getResources().getIdentifier(opt_str2, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                        opt2_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom));
                        opt1_img.setOnTouchListener(null);
                        opt3_img.setOnTouchListener(null);
                    }
                    if (getResources().getIdentifier(opt_str3, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                        opt3_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom));
                        opt2_img.setOnTouchListener(null);
                        opt1_img.setOnTouchListener(null);
                    }
                    mp_wrong.start();
                    onButtonShowPopupWindowClick("wrong", "Correct answer is " + answer);
                }
                return false;
            }
        });

        opt3_img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (getResources().getIdentifier(opt_str3, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                    opt3_img.setBackgroundColor(Color.parseColor("#00CC00"));
                    //tv.setText("CORRECT ANSWER!");
                    opt3_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                    opt1_img.setOnTouchListener(null);
                    opt2_img.setOnTouchListener(null);
                    mp_correct.start();
                    onButtonShowPopupWindowClick("correct", null);
                    SCORE++;
                } else {
                    opt3_img.setBackgroundColor(Color.parseColor("#EB3232"));
                    //tv.setText("WRONG ANSWER!");
                    //tv_ans.setText("Correct answer is " + answer);
                    opt3_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));

                    if (getResources().getIdentifier(opt_str1, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                        opt1_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom));
                        opt2_img.setOnTouchListener(null);
                        opt3_img.setOnTouchListener(null);
                    }
                    if (getResources().getIdentifier(opt_str2, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                        opt2_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom));
                        opt1_img.setOnTouchListener(null);
                        opt3_img.setOnTouchListener(null);
                    }
                    if (getResources().getIdentifier(opt_str3, "drawable", getPackageName()) == getResources().getIdentifier(answer_img, "drawable", getPackageName())) {
                        opt3_img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom));
                        opt2_img.setOnTouchListener(null);
                        opt1_img.setOnTouchListener(null);
                    }
                    mp_wrong.start();
                    onButtonShowPopupWindowClick("wrong", "Correct answer is " + answer);
                }
                return false;
            }
        });


    }

    protected final static int getResourceID(final String resName, final String resType, final Context ctx)
    {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
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
    public void exitWindow(){
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_animalimg);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.exit_window, null);

        // create the popup window
        int width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        int height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, 0, 0, 0);
        final TextView ri = (TextView) popupView.findViewById(R.id.exittag);
        Button button = (Button) popupView.findViewById(R.id.yesbut);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(getApplicationContext(), ImagesActivityMenu.class);
                startActivity(i);
                finish();
            }
        });
        Button button1 = (Button) popupView.findViewById(R.id.nobut);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                popupWindow.dismiss();
            }
        });

    }

    public void onButtonShowPopupWindowClick(String a, String b) {

        // get a reference to the already created main layout
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_animalimg);

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
        final ImageView ri = (ImageView) popupView.findViewById(R.id.Result_image);
        ri.setImageDrawable(getResources().getDrawable(getResourceID(a, "drawable", getApplicationContext())));
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                popupWindow.dismiss();
                nextScreen();
            }
        }, TIME_OUT);

        if(COUNT >= LIMIT){

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(getApplicationContext(), animalimgscr.class);
                    i.putExtra("score", SCORE);
                    startActivity(i);
                }
            }, TIME_OUT1);

        }
        else{
            COUNT++;
        }


        // dismiss the popup window when touched
//        popupView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                popupWindow.dismiss();
//                return true;
//            }
//        });
//        popupView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if(event.getAction()== MotionEvent.ACTION_DOWN) {
//                    popupWindow.dismiss();
//                    final Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            RandomImage();
//                        }
//                    }, TIME_OUT1);
//                }
//                return true;
//            }
//        });
    }

    public void nextScreen(){
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                RandomImage();
            }
        }, TIME_OUT1);
    }

}
