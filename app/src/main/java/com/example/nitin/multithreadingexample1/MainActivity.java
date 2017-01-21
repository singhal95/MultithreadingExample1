package com.example.nitin.multithreadingexample1;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //ProgressBar p1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG",Thread.currentThread().getName().toString());
       // p1= (ProgressBar) findViewById(R.id.progressBar);
        t1= (TextView) findViewById(R.id.textView);
        new Thread(new Mythread()).start();

    }
    public class Mythread implements Runnable{
        @Override
        public void run() {
            Log.i("TAG",Thread.currentThread().getName().toString());
            for(int i=0;i<=100;i++)
            {
                final int finalI = i;
                MainActivity.this.runOnUiThread(new Runnable() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        Log.i("TAG",Thread.currentThread().getName().toString());
                       t1.setText(String.valueOf(finalI));
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
