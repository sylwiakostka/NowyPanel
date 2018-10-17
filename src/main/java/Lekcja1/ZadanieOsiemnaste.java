package Lekcja1;

public class ZadanieOsiemnaste {
    public static void main(String[] args) {
        int iloscLiczb = 3;
        int suma = 0;

        for (int i = 0; i < iloscLiczb; i++) {
            int parzysta = i * 2;
            suma = suma + parzysta;
        }

        System.out.print(suma);

    }
}
