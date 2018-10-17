package com.selenium.loops;

public class ChoinkaExercise {
    public static void main(String[] args) {
        int levels = 5;
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("*");


        }
    }
}