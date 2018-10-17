package com.selenium.objects;

public class ObjectsMain {
    public static void main(String[] args) {
        Car bmw = new Car ("BMW", "E340");
        Car audi = new Car ("Audi", "A5");
        //powyzej produkcja obiektu */


        System.out.println (bmw.getSpeed());
        System.out.println ("Accelerating");
        bmw.accelerate();
        bmw.accelerate();
        bmw.accelerate();
        System.out.println (bmw.getSpeed());
        System.out.println ("Stoping");
        bmw.stop();
        System.out.println(bmw.getSpeed());


    }
}
