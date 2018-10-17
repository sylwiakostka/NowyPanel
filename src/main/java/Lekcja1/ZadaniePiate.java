package Lekcja1;

public class ZadaniePiate {
    public static void main(String[] args) {
        int wysokosc1 = 7;
        int szerokosc1 = 4;

        int wysokosc2 = 4;
        int szerokosc2 = 8;

        for (int pionJeden = 0; pionJeden < wysokosc1; pionJeden++) {

            for (int poziomJeden = 0; poziomJeden < szerokosc1; poziomJeden++)
                System.out.print("L");
            System.out.println();
        }

        for (int pionDwa = 0; pionDwa < wysokosc2; pionDwa++) {

            for (int poziomDwa = 0; poziomDwa < szerokosc2; poziomDwa++)
                System.out.print("L");
            System.out.println();

        }
    }
}




