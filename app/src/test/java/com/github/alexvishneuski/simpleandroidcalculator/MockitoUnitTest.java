package com.github.alexvishneuski.simpleandroidcalculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class MockitoUnitTest {

    private ICalculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = spy(SimpleCalculatorImpl.class);
//        mCalculator = new Calculator();
    }

    @Test
    public void testAdd() {
        when(mCalculator.add(Matchers.anyFloat(),Matchers.anyFloat())).thenReturn(4f);
        float result = mCalculator.add(1,2);

        assertEquals(result, "4");
        assertEquals(mCalculator.add(Matchers.anyFloat(),Matchers.anyFloat()), "5");
    }

}
