package Lekcja1;

public class ZadanieTrzynaste {

    public static void main(String[] args) {
        int h = 5;


        for (int pionowo = 0; pionowo < h; pionowo++) {
            for (int poziono = 0; pionowo >= poziono; poziono++) {
                int liczba = pionowo *3;
                int liczba2 = liczba + (poziono*3) ;

                System.out.print(liczba2 + " ");

            }
            System.out.println();

        }

    }
}
