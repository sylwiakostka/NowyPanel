package com.selenium.tables;

public class ForEachExercise {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            System.out.println(value);
        }

        for (int value : numbers) {
            System.out.println(value);
        }

//tylko parzyste
        for (int value : numbers) {
            int modulo = value % 2;
            if (modulo == 0)
                System.out.println(value);
        }
    }
}

