package com.github.alexvishneuski.simpleandroidcalculator;

import java.math.BigDecimal;

public class SimpleCalculatorImpl implements ICalculator {
    @Override
    public BigDecimal add(BigDecimal one, BigDecimal two) {
        return one.add(two);
    }

    @Override
    public BigDecimal dif(BigDecimal one, BigDecimal two) {
        return one.subtract(two);
    }

    @Override
    public BigDecimal multiply(BigDecimal one, BigDecimal two) {
        return one.multiply(two);
    }

    @Override
    public BigDecimal divide(BigDecimal one, BigDecimal two) {
        return one.divide(two, 15, BigDecimal.ROUND_HALF_EVEN);
    }

    @Override
    public BigDecimal pow(BigDecimal one, BigDecimal two) {
        try {
            double tmpOne = one.doubleValue();
            double tmpTwo = two.doubleValue();
            double tmpResult = Math.pow(tmpOne, tmpTwo);
            return new BigDecimal(tmpResult);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("One of operands is to big for calculation. Try calculation again");
        }
    }
}
