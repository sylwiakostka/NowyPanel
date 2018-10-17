package ruszGłowa;

public class DooBeeDooBeeDo {
    public static void main(String[] args) {
        int x = 1;
        while (x < 3) {
            System.out.println("Doo");
            System.out.println("Bee");
            x = x + 1;
        }
        if (x == 3) {
            System.out.println("Do");
        }
    }
}


class Układaka {
    public static void main(String[] args) {
        int x = 3;
        while (x > 0) {
            if (x > 2) {
                System.out.print("a");
                x = x - 1;
                System.out.print("-");
            }
            if (x == 2) {
                System.out.print("b c");
                x = x - 1;
                System.out.print("-");
            }
            if (x == 1) {
                System.out.print("d");
                x = x - 1;
            }
        }
    }
}

class Cwizenie1A {
    public static void main(String[] args) {
        int x = 1;
        while (x < 10) {
            if (x < 3) {
                System.out.println("Wielkie X");
                x = x + 1;
            }
        }
    }
}

class Cwiczenie1B {
    public static void main(String[] args) {
        int x = 5;
        while (x > 1) {
            x = x - 1;
            if (x < 3) ;
            System.out.println("Malutkie x");

        }
    }
}

class Cwiczenie1C {
    public static void main(String[] args) {
        int x = 5;
        while (x > 1) {
            x = x - 1;
            if (x < 3) {
                System.out.println("Malutkie y");
            }
        }

    }
}


class Test {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        while (x < 5) {
            if (y < 5) {
                x = x + 1;
                if (y < 3) {
                    x = x - 1;
                }
            }
            y = y + 2;
            System.out.print(x + "" + y + " ");
            x = x + 1;
        }
    }
}
