package com.github.alexvishneuski.simpleandroidcalculator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class MockitoUnitTest {

    //Shorthand for mocks creation - @Mock annotation
    @Mock
    private ICalculator mMockCalculatorFirst;

    private ICalculator mMockCalculatorSecond;

    private ICalculator mSpyCalculatorThird;

    @Before
    public void setUp() {
        //for init of @Mock annotation
        MockitoAnnotations.initMocks(this);

        //another way of mock creation
        mMockCalculatorSecond = mock(ICalculator.class);

        //1. With spy need I use only classes?
        //create spies of real objects
        mSpyCalculatorThird = spy(SimpleCalculatorImpl.class);

    }


    //Some behaviour verifying
    @Test
    public void testBehaviourVerifying() {
        //using mock object
        mMockCalculatorFirst.add(1, 2);

        //verification
        verify(mMockCalculatorFirst).add(1, 2);
    }


    //Some stubbing

    @Test
    public void testStubbing() {
        //result stubbing
        when(mMockCalculatorFirst.add(Matchers.anyInt(), Matchers.anyInt())).thenReturn(10);

        //check stubbing
        int result = mMockCalculatorFirst.add(1, 1);
        assertEquals(result, 10);

        //wasn't stubbed
        int resultSecond = mMockCalculatorFirst.multiply(1, 1);
        assertEquals(resultSecond, 0);
    }


    //Argument matchers using

    @Test
    public void testArgumentMatchersUsing() {
        //stubbing using built-in anyInt() argument matcher
        when(mMockCalculatorFirst.add(Matchers.anyInt(), Matchers.anyInt())).thenReturn(10);
        //is true
        assertEquals(mMockCalculatorFirst.add(1, 2), 10);
    }


    //Some stubbing with exception

    @Test(expected = RuntimeException.class)
    public void testStubbingWithException() {
        //exception stubbing
        when(mMockCalculatorFirst.add(Matchers.anyInt(), Matchers.anyInt())).thenThrow(new RuntimeException());
        //following throws runtime exception
        mMockCalculatorFirst.add(1, 2);
    }


    //Verifying exact number of invocations / at least x / never

    @Test
    public void testInvocationsCount() {
        //using mock
        mMockCalculatorFirst.add(1, 2);
        mMockCalculatorFirst.add(1, 2);
        mMockCalculatorFirst.add(1, 2);

        //exact number of invocations verification
        verify(mMockCalculatorFirst, times(3)).add(1, 2);

        //verification using never(). never() is an alias to times(0)
        verify(mMockCalculatorFirst, never()).multiply(1, 2);

        //verification using atLeast()/atMost()
        verify(mMockCalculatorFirst, atLeastOnce()).add(1, 2);
        verify(mMockCalculatorFirst, atLeast(2)).add(1, 2);
        verify(mMockCalculatorFirst, atMost(5)).add(1, 2);
    }

    //Stubbing void methods with exceptions
    @Test(expected = RuntimeException.class)
    public void testVoidWithExceptions() {
        doThrow(new RuntimeException()).when(mMockCalculatorFirst).clear();
        //following throws RuntimeException:
        mMockCalculatorFirst.clear();
    }

    //Making sure interaction(s) never happened on mock
    @Test
    public void testNeverHappened() {
        //using mocks - only mockOne is interacted
        mMockCalculatorFirst.add(1, 2);

        //ordinary verification
        verify(mMockCalculatorFirst).add(1, 2);

        //verify that method was never called on a mock
        verify(mMockCalculatorFirst, never()).dif(1, 1);

        //verify that other mocks were not interacted
        verifyZeroInteractions(mMockCalculatorSecond);
    }

    // Spying on real objects
    @Test
    public void testSpying() {
        //optionally, I can stub out some methods:
        when(mSpyCalculatorThird.dif(1, 1)).thenReturn(100);

        //using the spy calls *real* methods
        assertEquals(mSpyCalculatorThird.add(1, 1), 2);

        //dif() method was stubbed -> 100 is result
        assertNotSame(mSpyCalculatorThird.dif(1, 1), 0);

        //optionally, I can verify
        verify(mSpyCalculatorThird).add(1, 1);
        verify(mSpyCalculatorThird).dif(1, 1);
    }

    //Important gotcha on spying real objects

    @Test(expected = RuntimeException.class)
    public void testGotchaSpyWithException() {
        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        when(mSpyCalculatorThird.divide(1, 0)).thenReturn(100);
    }

    @Test
    public void testGotchaSpy() {
        //I have to use doReturn() for stubbing
        doReturn(100).when(mSpyCalculatorThird).divide(1, 0);
    }

    //Resetting mocks
    @Test
    public void testMockReset() {
        //stubbing
        when(mMockCalculatorFirst.add(Matchers.anyInt(), Matchers.anyInt())).thenReturn(100);
        //is true
        assertEquals(mMockCalculatorFirst.add(1, 2), 100);

        //reseting
        reset(mMockCalculatorFirst);
        //at this point the mock forgot any interactions & stubbing

        //getting default value =0
        //getting default value =0
        assertEquals(mMockCalculatorFirst.add(1, 2), 0);
    }


    @Test
    public void testIteratorHelloWorld(){
        //arrange
        Iterator i=mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");
        //act
        String result=i.next()+" "+i.next();
        //assert
        assertEquals("Hello World", result);
    }
    @Ignore
    @Test
    public void testDifMethod() {
    }


}
