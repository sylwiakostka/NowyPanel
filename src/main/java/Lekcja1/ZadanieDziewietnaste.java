package Lekcja1;

public class ZadanieDziewietnaste {
    public static void main(String[] args) {
        int iloscLiczb = 5;
        int suma = 0;

        for (int i = 1; i <= iloscLiczb; i += 2) {
            int nieparzysta = i;
            suma = suma + nieparzysta;
        }

        System.out.print(suma);

    }
}

