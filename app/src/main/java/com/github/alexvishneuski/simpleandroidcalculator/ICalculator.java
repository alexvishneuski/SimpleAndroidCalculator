package com.github.alexvishneuski.simpleandroidcalculator;

interface ICalculator {
    //Returns the result of addition
    int add(int pOne, int pTwo);

    //Returns the result of subtraction
    int dif(int pOne, int pTwo);

    //Returns the result of multiplication
    int multiply(int pOne, int pTwo);

    //Returns the result of division
    int divide(int pOne, int pTwo);

    //Empty method
    void clear();


}
