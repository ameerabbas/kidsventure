package com.example.unais.kidsventure;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
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

import static com.example.unais.kidsventure.Counting.getResourceID;

public class Sums extends AppCompatActivity {

    final int NUM_OF_IMAGES = 8;
    final int NUM_OF_OPTIONS = 3;
    final Random rnd = new Random(System.currentTimeMillis());
	private static int TIME_OUT = 2000;
    private static int TIME_OUT1 = 1000;
    int COUNT = 0;
    int LIMIT = 9;
    boolean FINISH = false;
    int SCORE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sums);
        final MediaPlayer mp_tap = MediaPlayer.create(this, R.raw.tap);

        RandomImage();
        COUNT++;

        final ImageView close_btn = (ImageView) findViewById(R.id.close_button);
        close_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp_tap.start();
//                close_btn.setImageDrawable(getResources().getDrawable(getResourceID("close_clicked", "drawable", getApplicationContext())));
//                Intent i = new Intent(getApplicationContext(), MathActivityMenu.class);
//                startActivity(i);
//                finish();
                exitWindow();
                return false;
            }
        });

        //final ImageView next_btn = (ImageView) findViewById(R.id.next_button);
//
  //      next_btn.setOnTouchListener(new View.OnTouchListener() {
    //        @Override
      //      public boolean onTouch(View v, MotionEvent event) {
//
  //              RandomImage();
    //            return false;
      //      }
        //});

    }

    protected void RandomImage() {
        final MediaPlayer mp_correct = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer mp_wrong = MediaPlayer.create(this, R.raw.wrong);
        findViewById(R.id.option1).setBackgroundColor(0);
        findViewById(R.id.option2).setBackgroundColor(0);
        findViewById(R.id.option3).setBackgroundColor(0);

        int random_num = 1 + rnd.nextInt(NUM_OF_IMAGES-1); // +1 so that zero can not come

        int[] ans = {13, 8, 90, 88, 60, 9, 9, 17};  //(index number + 1) is the image number
        final int answer = ans[random_num-1];

        final ImageView img = (ImageView) findViewById(R.id.imgRandom);
        final ImageView opt1_img = (ImageView) findViewById(R.id.option1);
        final ImageView opt2_img = (ImageView) findViewById(R.id.option2);
        final ImageView opt3_img = (ImageView) findViewById(R.id.option3);

        final String str = "sum" + (random_num);
//        System.out.println("Picture name: "+ str + "Ans: " + answer + "RandomNum: "+ random_num);
//        System.out.println("Ans: "+ answer);

        img.setImageDrawable(getResources().getDrawable(getResourceID(str, "drawable", getApplicationContext())));
        img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textmove));

        ArrayList optionList = new ArrayList();

        optionList.add(answer);

        int[] values = {13, 9, 17, 8, 90, 88, 60, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // one option is answer, remaining two values are given from this array randomly. only those numbers which image is present in drawer
        Random random = new Random(System.currentTimeMillis());
        int random_number;

        //filling optionList array with 2 unique values other than answer, answer has been already added
        do{
            random_number = random.nextInt(values.length);
            if(optionList.size()>1){
                if(((int)optionList.get(0) != values[random_number]) && ((int)optionList.get(1) != values[random_number])){
                    optionList.add(values[random_number]);
                }
            }
            else{
                if((int)optionList.get(0) != values[random_number]){
                    optionList.add(values[random_number]);
                }
            }

        }while(optionList.size() != NUM_OF_OPTIONS );


        Collections.shuffle(optionList);

//        final TextView tv = (TextView) findViewById(R.id.Notification_text);
//        final TextView tv_ans = (TextView) findViewById(R.id.correct_ans);
        final String opt_str1 = "num" + (optionList.get(0));
        final String opt_str2 = "num" + (optionList.get(1));
        final String opt_str3 = "num" + (optionList.get(2));

        opt1_img.setImageDrawable(getResources().getDrawable(getResourceID(opt_str1, "drawable", getApplicationContext())));
        opt2_img.setImageDrawable(getResources().getDrawable(getResourceID(opt_str2, "drawable", getApplicationContext())));
        opt3_img.setImageDrawable(getResources().getDrawable(getResourceID(opt_str3, "drawable", getApplicationContext())));

        final String answer_img = "num" + answer;

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
//                    SCORE--;
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
//                    SCORE--;
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
//                    SCORE--;
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
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_sums);

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
                Intent i = new Intent(getApplicationContext(), MathActivityMenu.class);
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
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_sums);

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
                    Intent i = new Intent(getApplicationContext(), sumsscr.class);
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


