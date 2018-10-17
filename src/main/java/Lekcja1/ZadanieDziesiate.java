package Lekcja1;

public class ZadanieDziesiate {

    public static void main(String[] args) {
        int levels = 4;
        for (int wysokosc = 0; wysokosc < levels; wysokosc++) {
            for (int szerokosc = 0; szerokosc < wysokosc; szerokosc++) {
                if (wysokosc == 2 && szerokosc == 1) {
                    System.out.print(' ');
                } else if (wysokosc == 3 && szerokosc == 1 || szerokosc == 2) {
                    System.out.print(' ');
                } else {
                    System.out.print("X");
                }
            }
            System.out.println("X");

        }
        for (int wysokosc = 0; wysokosc <= levels; wysokosc++) {
            System.out.print("X");
        }
    }
}
