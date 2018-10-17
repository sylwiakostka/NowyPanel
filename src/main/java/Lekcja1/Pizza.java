package Lekcja1;

public class Pizza {
    public static void main(String[] args) {
        String pizza = "kebab";
        if ("calzone".equals(pizza)) {
            System.out.println("składniki calzone: mąka, warzywa, sos pomidorowy, ser");

        } else if ("hawajska".equals(pizza)) {
            System.out.println("składniki hawajska: ananas, ser, bekon");

        } else if ("kebab".equals(pizza)) {
            System.out.println("składniki kebab: baranina, ser, kabanos");

        } else {
            System.out.println("zły wybor");
        }
    }
}
