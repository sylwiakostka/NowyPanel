package Lekcja1;

public class ZadanieCzternaste {

    public static void main(String[] args) {

        int h = 5;

        for (int pionowo = 0; pionowo < h; pionowo++) {
            int liczba = (int)Math.pow(2,pionowo+1);
            for (int poziono = 0; pionowo >= poziono; poziono++) {

                int liczba2 = liczba+poziono;


                System.out.print(liczba2 + ",");

            }
            System.out.println();

        }
    }
}
