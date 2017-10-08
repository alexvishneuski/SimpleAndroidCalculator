package com.github.alexvishneuski.simpleandroidcalculator;

public class SimpleCalculatorImpl implements ICalculator {
    @Override
    public float add(float one, float two) {
        return one + two;
    }

    @Override
    public float dif(float one, float two) {
        return one - two;
    }

    @Override
    public float multiply(float one, float two) {
        return one * two;
    }

    @Override
    public float divide(float one, float two) {
        if (two == 0) return 0;
        return one / two;
    }
}
