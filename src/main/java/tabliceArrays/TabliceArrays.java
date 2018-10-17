package tabliceArrays;

import java.util.Arrays;

public class TabliceArrays {
    public static void main(String[] args) {
        int[] liczby = {1, 5, 3, 6, 2, 1};
        System.out.println("Zawartość tablicy liczby: " + Arrays.toString(liczby));  // Wyswietlenie zawartości tablicy

        int[] kopia = Arrays.copyOf(liczby, liczby.length); // Kopiowanie tablicy liczby
        System.out.println("kopia tablicy liczby:" + kopia);
        Arrays.sort(kopia);
        System.out.println("Sortowanie tablicy kopia: " + Arrays.toString(kopia)); //sortowanie tablicy kopia

        int[] jedynki = new int[6]; // nowa tablica 6-elementowa
        Arrays.fill(jedynki, 1); // Wypełnianie calej tablicy wartoscią 1
        System.out.println("Zawartość tablicy jedynki:" + Arrays.toString(jedynki)); //wyświetlenie zawartosci tablicy


//**częściowe skopiowanie tablic. - zawartość tablicy liczby jest, począwszy od indeksu index2 kopiowania do tablicy2 - jedynki,
// przy czym elementy są umieszczane począwszy od indeksu index2 - 1, kopiowana jest liczba elementów równa wartości liczbaElementow - 4.
// model: System.arraycopy(tablica1, indexStart1, tablica2, indexStart2, liczbaElementow)
        System.arraycopy(liczby, 2, jedynki, 1, 4);
        System.out.println("Mix tablic" + Arrays.toString(jedynki));

        System.out.println("Porównanie tablicy liczy i kopia: " + Arrays.equals(liczby, kopia)); // porównanie tablic
        System.out.println("Porównanie tablicy liczby i jedynki: " + Arrays.equals(liczby, jedynki)); //porównanie tablic

        String[] imiona = {"Marta", "zuzia", "tomek"};
        Arrays.sort(imiona);
        System.out.println("Imiona posortowane:" + Arrays.toString(imiona));

        //towrze nowa tablice numerydo10 i zapelniam ja danymi
        int[] numery0do10 = new int[11];
        for (int i = 0; i < numery0do10.length; i++)
            numery0do10[i] = i + 1;
        //losowanie 4 liczb i zapisanie ich do drugiej tablicy
        int[] result = new int[4];
        for (int i = 0; i < result.length; i++) {
            //losowanie indeksu z zakresu od 0 11-1 - bo liczby sie od 0 indeksy
            int r = (int) (Math.random() * 11);
            //wynik pierwszego losowania
            System.out.println("pierwsze losowanie " + r);


        }

        }


    }





