package Lekcja1;

public class ZadanieDwudzieste {
    public static void main(String[] args) {
        int iloscLiczb = 20;
        int suma = 0;
        int dodaneLiczby = 0;

        for (int j = 1; j <= iloscLiczb; j++) {
            if (j % 10 == 1 || j % 10 == 2 || j % 10 == 7) {
                suma += j;
                dodaneLiczby++;
            }
        }
        System.out.print(suma);
    }
}
