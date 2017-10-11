package com.github.alexvishneuski.simpleandroidcalculator;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 26)
public class RobolectricTest {

    private ActivityController<CalculatorActivity> activityController;
    private CalculatorActivity calculatorActivity;

    @Before
    public void init() {
        activityController = Robolectric.buildActivity(CalculatorActivity.class);
        String mInputFirstEditText = "10";
        String mInputSecondEditText = "20";
    }

    @Test
    public void testActivityRun() {

        activityController.create().start().resume();

        calculatorActivity = activityController.get();

        boolean isAddEnabled = calculatorActivity.findViewById(R.id.add_button).isEnabled();
        assertEquals(isAddEnabled, false);
        assertFalse(isAddEnabled);
    }

    @Test
    public void testOperation() {

        activityController.create().start().resume();

        calculatorActivity = activityController.get();


        EditText mInputFirstEditText = (EditText) calculatorActivity.findViewById(R.id.input_field_one_edit_text);
        EditText mInputSecondEditText = (EditText) calculatorActivity.findViewById(R.id.input_field_two_edit_text);
        TextView mResultTextView = (TextView)calculatorActivity.findViewById(R.id.result_text_view);
        View mAddButton = calculatorActivity.findViewById(R.id.add_button);
        mInputFirstEditText.setText("10");
        mInputSecondEditText.setText("20");
        mAddButton.performClick();
        assertEquals(mResultTextView.getText().toString(), "30");
    }


    @After
    public void destroy() {
//        activityController.pause().stop().destroy();
    }


}
