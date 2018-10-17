package com.selenium.objects;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static final String MAKE = "some make";
    private static final String MODEL = "some model";
    private Car car;

    @BeforeEach
    public void createCar() {
        car = new Car(MAKE, MODEL);
    }

    @Test
    @DisplayName("Check make and model")
    void freshCarShouldHaveMakeAndModel() {
        Assertions.assertEquals(car.getMake(), MAKE);
        Assertions.assertEquals(car.getModel(), MODEL);
    }

    @Test
    void shouldAccelerate() {
        int speed = 10;
        for (int i = 0; i < speed; i++) car.accelerate();
        Assertions.assertEquals(car.getSpeed(), speed);
    }

    @Test
    void shouldNotPassSpeedLimit() {

    }

    @Test
    void shouldStartWithZeroSpeed() {
        Assertions.assertEquals(0, car.getSpeed());

    }

    @Test
    void shouldSetSpeedProperly() {
        car.setSpeed(6);
        Assertions.assertEquals(6,car.getSpeed());
    }

    @Test
    void speedShouldNotBeLowerThanZero() {

        car.setSpeed(-5);
        Assertions.assertTrue(car.getSpeed()>=0);
    }

    @Test
    void shouldNotBeAbleToSetSpeedOverLimit() {
        //given
        int currentSpeed = car.getSpeed();
        int newSpeed = Car.SPEED_LIMIT + 10;

        //when
        car.setSpeed(newSpeed);

        //then
        Assertions.assertEquals(car.getSpeed(), currentSpeed);

    }

    @Test
    void shouldStop() {
        //given
        car.setSpeed(20);
        //lub car.accelerate()

        //when
        car.stop();

        //then
        Assertions.assertEquals( 0, car.getSpeed());
    }


}

