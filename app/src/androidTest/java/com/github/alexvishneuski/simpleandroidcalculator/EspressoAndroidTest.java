package com.github.alexvishneuski.simpleandroidcalculator;

import android.content.Intent;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class EspressoAndroidTest {

    private ActivityTestRule<CalculatorActivity> calculatorActivity = new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void testActivityRun() {

        calculatorActivity.launchActivity(new Intent());

        ViewInteraction addButton = onView(withId(R.id.add_button));
        addButton.check(matches(isDisplayed()));
        addButton.check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (view.isEnabled()) {
                    throw new IllegalStateException("button enabled");
                }
            }
        });

        onView(withId(R.id.input_field_one_edit_text)).perform(typeText("10"));
        onView(withId(R.id.input_field_two_edit_text)).perform(typeText("20"));

        addButton.check(matches(isEnabled()));

        addButton.perform(click());

        onView(withId(R.id.result_text_view)).check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (!((TextView) view).getText().toString().equals("30")) {
                    throw new IllegalStateException("result wrong. expected 30");
                }
            }
        });

    }
}
