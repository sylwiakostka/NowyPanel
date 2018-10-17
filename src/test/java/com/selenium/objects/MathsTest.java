package com.selenium.objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathsTest {

    @Test
    void shouldAddCorrectly() {
        //given
        int someNumber = 2;
        int sum = someNumber + someNumber;

        Assertions.assertEquals(sum, Maths.sum(someNumber, someNumber));
    }

    @Test
    void shouldSumCorrectWithZero(){
        int someNumber = 2;
        int someNumber2 = 0;
        int sum = someNumber + someNumber2;
        Assertions.assertEquals(sum, Maths.sum(someNumber, someNumber2));
    }


    @Test
    void shouldSumCorrectWithMinusNumber() {
        int someNumber = 2;
        int someNumber2 = -1;
        int sum = someNumber + someNumber2;
        Assertions.assertEquals(sum, Maths.sum(someNumber, someNumber2));

    }


}