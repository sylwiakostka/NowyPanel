package Lekcja1;

public class ZadanieSiedemnaste {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;

        while (a > 0 && b > 0) {
            int pole = a * b;
            System.out.println("Pole figury to: " + pole);
            break;
        }
        while (a <= 0 || b <= 0) {
            System.out.println("Podaj wartości dodanie!");
            break;
        }

    }
}
