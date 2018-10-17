package ruszGłowa.Konstruktory;

public class Kaczka {
    int kilo = 6;
    float lotnosc = 2.1F;
    String imie = "Ogólna";
    long[] piora = {1, 2, 3, 4, 5, 6, 7};
    boolean mozeLatac = true;
    int maksSzybkosc = 25;

    public Kaczka() {
        System.out.println("Kaczka typu 1");
    }

    public Kaczka(boolean lotna) {
        mozeLatac = lotna;
        System.out.println("Kaczka typu 2");
    }

    public Kaczka(String i, long[] p) {
        imie = i;
        piora = p;
        System.out.println("Kaczka typu 3");
    }

    public Kaczka(int w, float l) {
        kilo = w;
        lotnosc = l;
        System.out.println("Kaczka typu 4");
    }

    public Kaczka(float gestosc, int maks) {
        lotnosc = gestosc;
        maksSzybkosc = maks;
        System.out.println("Kaczka typu 5");
    }

}
