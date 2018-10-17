package com.selenium.tables;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Numbers {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);

        //dodawanie
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }

        //wyswietlanie co drugi
        for (int i = 0; i < numbers.size(); i = i + 2) {
            System.out.println(numbers.get(i));
        }

        //wyswietlanie nieparzyste
        for (int value : numbers) {
            int modulo = value % 2;
            if (modulo != 0)
                System.out.println(value);
        }
    }
}