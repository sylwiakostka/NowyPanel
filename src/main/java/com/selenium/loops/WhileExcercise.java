package com.selenium.loops;

public class WhileExcercise {
    public static void main(String[] args) {
        int starsAmount = 5;
        int i = 0;
        while (i < starsAmount) {
            System.out.print("*");
            if (i < starsAmount - 1)
                System.out.print(",");
            i++;


        }
    }
}
