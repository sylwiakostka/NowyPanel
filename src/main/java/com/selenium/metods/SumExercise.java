package com.selenium.metods;

public class SumExercise {
    public static void main (String [] args) {
        int someSum = sum( 1, 2);
        System.out.println(someSum);
        System.out.println(sum(3, 4));
    }
    public static int sum (int a, int b) {
        return a + b;
    }
}


