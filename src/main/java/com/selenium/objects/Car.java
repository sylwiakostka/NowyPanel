package com.selenium.objects;

//klasa samochodu - klasa domenowa, modeluje rzeczywistosc*/
public class Car {

    //ponizej hermetyzacja - zachowanie dostepne na zewnatrz, parametry juz nie*//
    private int speed = 0;
    private String make;
    private String model;
    static final int SPEED_LIMIT = 250;

    //konstruktor ponizej -  stawarza obiekt, typ metody, jego nazwa jak nazwa klasy; generalnie jest w javie konstruktor bezparametrowy, ktorego nie musimy pisac; wywyoluje sie tylko raz przy tworzeniu obiektu  *//
    public Car(String newMake, String newModel) {
        make = newMake;
        model = newModel;
    }


    public void accelerate() {
        if (speed >= 250) return;
        speed++;
        //okreslenie max predkosci na 250*/
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        if (newSpeed < SPEED_LIMIT && newSpeed > 0) {
            speed = newSpeed;
        }
    }

    public void stop() {
        if (1 == 1)
            System.out.println();

        if (1 == 1) {
            System.out.println();
        }
        speed = 0;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}
