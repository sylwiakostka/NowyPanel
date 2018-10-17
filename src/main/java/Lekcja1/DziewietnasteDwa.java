package Lekcja1;

public class DziewietnasteDwa {

    public static void main(String[] args) {
        int iloscLiczb = 5;
        int suma = 0;
        int dodaneLiczby = 0;

        for (int i = 1; i <= iloscLiczb; i++) {
            if (i % 2 != 0) {
                suma += i;
                dodaneLiczby++;
            }
        }
        System.out.print(suma);
    }

}


