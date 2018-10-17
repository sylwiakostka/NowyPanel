package Lekcja1;

public class ZadanieJedenaste {
    public static void main(String[] args) {
        int h=5;



        for (int pionowo =1; pionowo<h+1; pionowo++){
            for (int poziono =1; pionowo>poziono; poziono++)
                System.out.print(poziono + " ");
            System.out.println(pionowo);

        }

    }
}
