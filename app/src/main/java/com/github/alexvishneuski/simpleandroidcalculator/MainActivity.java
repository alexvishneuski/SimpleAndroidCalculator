package com.github.alexvishneuski.simpleandroidcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startCalculatorActivity();
    }

    public void startCalculatorActivity() {
        startActivity(new Intent(this, CalculatorActivity.class));
    }

}
