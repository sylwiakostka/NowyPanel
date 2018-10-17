package Kurs1024kb;

public class Math {

    public static int calculateSum(int [] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum +=number;
        }
        return sum;
    }

    public static int multiplyNumbers (int [] numbers) {
        int result = 1;
        for (int number : numbers){
            result *=number;
        }
        return result;
    }


    public static float calculateAverage(int [] numbers){
        return calculateSum(numbers)/ (float)numbers.length;
    }

}
