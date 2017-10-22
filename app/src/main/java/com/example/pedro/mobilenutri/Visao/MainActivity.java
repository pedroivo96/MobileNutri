package com.example.pedro.mobilenutri.Visao;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pedro.mobilenutri.R;

public class MainActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(this, 4000);

    }

    @Override
    public void run() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}
