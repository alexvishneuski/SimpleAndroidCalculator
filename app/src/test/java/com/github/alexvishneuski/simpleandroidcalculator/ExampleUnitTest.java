package com.github.alexvishneuski.simpleandroidcalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private ICalculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new SimpleCalculatorImpl();
    }

    @After
    public void destroy() {
        //some cleaning
    }

    @Test
    public void addTest() {
        int result = mCalculator.add(2, 1);
        assertEquals(result, 3);
    }

    @Test
    public void difTest() {
        int result = mCalculator.dif(2, 1);
        assertEquals(result, 1);
    }

    @Test
    public void multiplyTest() {
        int result = mCalculator.multiply(2, 1);
        assertEquals(result, 2);
    }

    @Test
    public void divideTest() {
        int result = mCalculator.divide(2, 1);
        assertEquals(result, 2);
    }

    @Test(expected = RuntimeException.class)
    public void divisionByZeroTest() {
        mCalculator.divide(2, 0);
    }


}