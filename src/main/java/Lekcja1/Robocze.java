package Lekcja1;

public class Robocze {

    public static void main(String[] args) {
        int h = 5;


        for (int pionowo = 0; pionowo < h; pionowo++) {
            for (int poziono = 0; pionowo > poziono; poziono++) {

                System.out.print(poziono + " ");

            }
            System.out.println(pionowo);
        }

    }
}
