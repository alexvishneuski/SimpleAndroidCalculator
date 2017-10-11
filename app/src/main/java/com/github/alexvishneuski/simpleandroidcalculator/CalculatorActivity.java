package com.github.alexvishneuski.simpleandroidcalculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    public static final String TAG = "CalculatorActivity";

    private ICalculator mCalculator = new SimpleCalculatorImpl();

    //input fields
    private EditText mInputOneEditText;
    private EditText mInputTwoEditText;

    //buttons
    private View mAddButton;
    private View mDifButton;
    private View mMultiplyButton;
    private View mDevideButton;

    //result field
    private TextView mResultTextView;


    @Override
    protected void onCreate(@Nullable Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_calculator);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }


    private void initView() {

        mInputOneEditText = (EditText) findViewById(R.id.input_field_one_edit_text);
        mInputTwoEditText = (EditText) findViewById(R.id.input_field_two_edit_text);

        mAddButton = findViewById(R.id.add_button);
        mDifButton = findViewById(R.id.dif_button);
        mMultiplyButton = findViewById(R.id.multiply_button);
        mDevideButton = findViewById(R.id.devide_button);

        mResultTextView = (TextView) findViewById(R.id.result_text_view);


        mInputOneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                if (length > 0) {
                    mAddButton.setEnabled(true);
                    mDifButton.setEnabled(true);
                    mMultiplyButton.setEnabled(true);
                    mDevideButton.setEnabled(true);

                } else {
                    mAddButton.setEnabled(false);
                    mDifButton.setEnabled(false);
                    mMultiplyButton.setEnabled(false);
                    mDevideButton.setEnabled(false);
                }
            }
        });

        mInputTwoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                if (length > 0) {
                    mAddButton.setEnabled(true);
                    mDifButton.setEnabled(true);
                    mMultiplyButton.setEnabled(true);
                    mDevideButton.setEnabled(true);

                } else {
                    mAddButton.setEnabled(false);
                    mDifButton.setEnabled(false);
                    mMultiplyButton.setEnabled(false);
                    mDevideButton.setEnabled(false);
                }
            }
        });


        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = Integer.toString(mCalculator.add(Integer.parseInt(mInputOneEditText.getText().toString()), Integer.parseInt(mInputTwoEditText.getText().toString())));
                showResult(result);
            }
        });

        mDifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = Integer.toString(mCalculator.dif(Integer.parseInt(mInputOneEditText.getText().toString()), Integer.parseInt(mInputTwoEditText.getText().toString())));
                showResult(result);
            }
        });

        mMultiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = Integer.toString(mCalculator.multiply(Integer.parseInt(mInputOneEditText.getText().toString()), Integer.parseInt(mInputTwoEditText.getText().toString())));
                showResult(result);
            }
        });

        mDevideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = Integer.toString(mCalculator.divide(Integer.parseInt(mInputOneEditText.getText().toString()), Integer.parseInt(mInputTwoEditText.getText().toString())));
                showResult(result);
            }
        });


    }

    private void showResult(String result) {
        mResultTextView.setText(result);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
