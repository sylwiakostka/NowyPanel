package Lekcja1;

public class Petla {
    public static void main(String[] args) {

        for (int i = 3; i < 101; i++) {

            if (i % 5 == 0 && i % 3 == 0) System.out.println(i + " buzz" + " fizz");
            else if (i % 3 == 0) System.out.println(i + " fizz");
            else if (i % 5 == 0) System.out.println(i + " buzz");
        }
    }
}
