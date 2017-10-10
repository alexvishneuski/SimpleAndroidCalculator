package com.github.alexvishneuski.simpleandroidcalculator;

public class SimpleCalculatorImpl implements ICalculator {
    @Override
    public int add(int pOne, int pTwo) {
        return pOne + pTwo;
    }

    @Override
    public int dif(int pOne, int pTwo) {
        return pOne - pTwo;
    }

    @Override
    public int multiply(int pOne, int pTwo) {
        return pOne * pTwo;
    }

    @Override
    public int divide(int pOne, int pTwo) {
        //if (two == 0) return 0;
        if (pTwo == 0) throw new RuntimeException("devided on zero");
        return pOne / pTwo;
    }

    @Override
    public void clear() {
        //To do Nothing
    }
}
