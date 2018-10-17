package com.selenium.loops;

public class ForExercise {
    public static void main(String[] args) {
        int starsAmount = 5;
        for (int i = 0; i < starsAmount; i++) {
            System.out.print("*");
            if (i < starsAmount - 1)
                System.out.print(",");

        }


    }
}
