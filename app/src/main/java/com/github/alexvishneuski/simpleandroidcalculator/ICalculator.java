package com.github.alexvishneuski.simpleandroidcalculator;

import java.math.BigDecimal;

public interface ICalculator {
    //Returns the result of addition
    BigDecimal add(BigDecimal one, BigDecimal two);

    //Returns the result of subtraction
    BigDecimal dif(BigDecimal one, BigDecimal two);

    //Returns the result of multiplication
    BigDecimal multiply(BigDecimal one, BigDecimal two);

    //Returns the result of division
    BigDecimal divide(BigDecimal one, BigDecimal two);

    //Returns the result of involution to power
    BigDecimal pow(BigDecimal one, BigDecimal two);

}
