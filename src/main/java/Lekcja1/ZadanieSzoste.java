package Lekcja1;

public class ZadanieSzoste {
    public static void main(String[] args) {

        int szerokosc = 10;
        int wysokosc = 4;

        for (int pion = 0; pion < wysokosc; pion++) {
            for (int poziom = 1; poziom < szerokosc; poziom++)
                System.out.print("X");
            System.out.println("X");

        }

    }
}
