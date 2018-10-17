package ruszGłowa.ArrayList;

import java.util.*;

public class ArrayListMagnet {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add(0, "zero");
        a.add(1, "jeden");
        a.add(2, "dwa");
        a.add(3, "trzy");
        printAL(a);

        if (a.contains("trzy")) {
            a.add("cztery");
        }
        a.remove(2);
        printAL(a);

        if (a.indexOf("pięć") != 4) {
            a.add(4, "4.2");
        }
        printAL(a);

        if (a.contains("dwa")) {
            a.add("2.2");
        }
        printAL(a);
    }
//ArrayList<>al - wszystkie elem. tablicy
    public static void printAL(ArrayList<String> al) {
        for (String element : al) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }
}
