package ruszGłowa;

public class KsiazkaTablice {
    String tytul;
    String autor;
}

class KsiazkaTest {
    public static void main(String[] args) {
        KsiazkaTablice[] mojeKsiazki = new KsiazkaTablice[3];
        mojeKsiazki[0] = new KsiazkaTablice();
        mojeKsiazki[1] = new KsiazkaTablice();
        mojeKsiazki[2] = new KsiazkaTablice();

        mojeKsiazki[0].tytul = "Czterech rycerzy";
        mojeKsiazki[1].tytul = "Trzech walecznych";
        mojeKsiazki[2].tytul = "Dwóch śmiałych";
        mojeKsiazki[0].autor = "Ja";
        mojeKsiazki[1].autor = "Ona";
        mojeKsiazki[2].autor = "Rodzice";

        int x = 0;
        while (x < 3) {
            System.out.print(mojeKsiazki[x].tytul);
            System.out.print(" , autor ");
            System.out.println(mojeKsiazki[x].autor);
            x = x + 1;
        }

    }

}
