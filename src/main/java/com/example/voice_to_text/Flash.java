package com.example.voice_to_text;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Flash extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash);
        progressBar=findViewById(R.id.progressBar);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
                startapp();

            }
        });
        thread.start();
    }

    private void startapp() {
        Intent intent=new Intent(Flash.this,MainActivity.class);
        startActivity(intent);

    }

    private void dowork() {
        for (progress=30;progress<=100;progress=progress+30){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
