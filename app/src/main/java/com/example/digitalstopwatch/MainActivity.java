package com.example.digitalstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int milliseconds=0;
    boolean isrunning=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.timertext);
        startTimer();

    }
    public  void onClickStart(View view){
        isrunning=true;

    }
    public void onClickStop(View view){
        isrunning=false;

    }
    public void onClickReset(View view){
            isrunning=false;
        milliseconds=0;
    }

    public void startTimer(){
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int ms=milliseconds%10;
        int s=milliseconds/10;
        int m=s/60;
        int h=m/60;
        if(isrunning) {
            milliseconds++;
        }
        String formatString=String.format(Locale.getDefault(),"%02d:%02d:%02d:%02d",h,m,s,ms);
        textView.setText(formatString);
        handler.postDelayed(this,100);
            }
        };
        handler.post(runnable);
    }

}