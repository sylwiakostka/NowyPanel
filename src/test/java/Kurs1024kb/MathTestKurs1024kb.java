package Kurs1024kb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTestKurs1024kb {


    @Test
    void calculateSum() {
        int[] numbers = {1, 2, 3, 4};
        int result = Math.calculateSum(numbers);
        Assertions.assertEquals(10, result);
    }

    @Test
    void multiplyNumbers() {
        int[] numbers = {1, 2, 3, 4};
        int result = Math.multiplyNumbers(numbers);
        Assertions.assertEquals(24, result);
    }



    @Test
    void calculateAverage() {
        int[] numbers = {1, 2, 3, 4};
       float result = Math.calculateAverage(numbers);
       Assertions.assertEquals(2.5, result);

    }
}