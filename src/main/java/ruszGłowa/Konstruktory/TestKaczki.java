package ruszGłowa.Konstruktory;

public class TestKaczki {
    public static void main(String[] args) {

        int waga = 6;
        float gestosc = 2.1F;
        String imie = "Donald";
        long [] piora = {1,2,3,4,5,6};
        boolean mozeLatac = true;
        int szybkoscLotu = 25;

        Kaczka [] k = new Kaczka[7];
        k[0] = new Kaczka();
        k[1] = new Kaczka(gestosc,waga);
        k[2] = new Kaczka(imie, piora);
        k[3] = new Kaczka(mozeLatac);
        k[4] = new Kaczka(3.3F, szybkoscLotu);
        k[5] = new Kaczka(false);
        k[6] = new Kaczka(szybkoscLotu,gestosc);

    }
}
