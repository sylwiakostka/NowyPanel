package ruszGłowa;

public class HobbitTablica {
    String imie;

    public static void main(String[] args) {
        HobbitTablica[] h = new HobbitTablica[3];
        int z = -1; //bo indeksy elementow tablic zaczynaja sie od wartosci 0

        while (z < 2) {
            z = z + 1;
            h[z] = new HobbitTablica();
            h[z].imie = "Bilbao";
            if (z == 1) {
                h[z].imie = "Frodo";
            }
            if (z == 2) {
                h[z].imie = "Frodo";
            }
            System.out.print(h[z].imie + " jest ");
            System.out.println("dobrym imieniem dla hobbita");
        }

    }
}
