package Lekcja1;

public class ZadanieDwidziestepierwsze {
    public static void main(String[] args) {
        int iloscLiczb = 100;
        int suma = 0;
        int dodaneLiczby = 0;

        for (int j = 1; j <= iloscLiczb; j++) {
            if (j % 100 == 17 || j % 100 == 31 || j % 100 == 62) {
                suma += j;
                dodaneLiczby++;
            }
        }
        System.out.print(suma);
    }
}

