package Lekcja1;

public class ZadanieDziewiate {

    public static void main(String[] args) {
        int levels = 5;
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("X");
            }
            System.out.println("X");

        }
        System.out.println(" ");

        for (int i = 0; i < levels; i++) {
            for (int j = 4; j > i; j--) {
                System.out.print("X");
            }

            System.out.println("X");
        }
        System.out.println(" ");


    }
}