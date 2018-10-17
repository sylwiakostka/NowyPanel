package com.selenium.tables;

public class TableExercise2 {
    public static void main(String[] args) {

        int[] number = {1, 2, 3, 4, 5};

        int[] otherNumbers = new int[5];
        otherNumbers[0] = 1;
        otherNumbers[1] = 2;
        otherNumbers[2] = 3;
        otherNumbers[3] = 4;
        otherNumbers[4] = 5;

        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
            //wyswietlenie co drugiej wartosci - wpisujemy nie i++ ale i=i+2
        }
        System.out.println();
        System.out.println("Parzyste");
        //tylko parzyste - dzielenie przez 2 rowne 0
        for (int i = 0; i < number.length; i++) {
            int index = i;
            int value = number[i];
            int modulo = value % 2;
            if (modulo == 0)
                System.out.println(number[i]);
        }
    }
}