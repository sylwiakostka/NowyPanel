package ruszGłowa.ArrayList;

import java.util.ArrayList;

public class Drzewa {
    public static void main(String[] args) {

        //tworzenie tablicy - listy obiektow klasy Drzewo
        ArrayList<Drzewa> mojaTbl = new ArrayList<Drzewa>();

        //dodanie obiektów do tablicy
        Drzewa brzoza = new Drzewa();
        mojaTbl.add(brzoza);

        Drzewa lipa = new Drzewa();
        mojaTbl.add(lipa);

        Drzewa sosna = new Drzewa();
        mojaTbl.add(sosna);

        Drzewa jodła = new Drzewa();
        mojaTbl.add(jodła);

        //określenie ilosci elementow tablicy
        int ilosc = mojaTbl.size();
        System.out.println("ilosc elementow tablicy: " + ilosc);

        //sprawdzenie czy tablica zawier wsakzany obiekt
        boolean czyJest = mojaTbl.contains(jodła);
        System.out.println("czy w tablicy jest jodła: " + czyJest);

        //okreslenie polozenia obiektu - jego indeksu
        int indeks = mojaTbl.indexOf(sosna);
        System.out.println("która jest sosna: " + indeks);

        //sprawdzenie czy tablica jest pusta
        boolean czyPusta = mojaTbl.isEmpty();
        System.out.println("czy tablica jest pusta: " + czyPusta);

        //usuniecie wskazanego elementu z tablicy
        mojaTbl.remove(jodła);
        boolean czyJestJodla = mojaTbl.contains(jodła);
        System.out.println("czy nadal jest jodła: " + czyJestJodla);


    }


}

