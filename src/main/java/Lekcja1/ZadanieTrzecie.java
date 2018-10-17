package Lekcja1;

public class ZadanieTrzecie {
    public static void main(String[] args) {
        int szerokosc = 10; //j
        int wysokosc = 4; //i

        for (int pozycjaPion = 0; pozycjaPion < wysokosc; pozycjaPion++) {
            for (int pozycjaPoziom = 0; pozycjaPoziom < szerokosc; pozycjaPoziom++) {
                if (pozycjaPion == 0 || pozycjaPion == wysokosc - 1) {
                    System.out.print("X");
                } else if (pozycjaPoziom == 0 || pozycjaPoziom == szerokosc - 1) {
                    System.out.print("X");
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}
