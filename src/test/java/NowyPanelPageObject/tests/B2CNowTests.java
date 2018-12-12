package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;


public class B2CNowTests extends TestConfig {


    @org.testng.annotations.Test
    public void shouldMakeBasicOrder() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Wernyhory 13, Warszawa", "Jasna 6, Warszawa")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderLuxuryTaxi() throws InterruptedException {

        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Rolna 167, Warszawa", "Wronia 1, Warszawa")
                .choseLuxuryTaxi()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderPopularTaxi() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Wałbrzyska 42, Warszawa", "Jerozolimskie 54, Warszawa")
                .chosePopularTaxi()
                .addComment("panna anna")
                .addNote("a nic")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTwoTaxis() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Prosta 6, Warszawa", "Trawiasta 1, Warszawa")
                .orderTwoTaxis()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderThreeTaxis() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Al. Lotników 1, Warszawa", "Sasanki 2, Warszawa")
                .orderThreeTaxis()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiFeeBetweenDwoAndThreePLN() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Sasanki 6, Warszawa", "Wawelska 4, Warszawa")
                .dragAndDropeLeft(180, 0, "2 zł")
                .dragAndDropeRight(-350, 0, "3 zł")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiFeeBetweenThreeAndFourPLN() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Plater E. 2, Warszawa", "Pl. Szembeka, Warszawa")
                .dragAndDropeLeft(345, 0, "3 zł")
                .dragAndDropeRight(-171, 0, "4 zł")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiFeeBetweenFourAndFivePLN() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Chmielna 1, Warszawa", "Grochowska 100, Warszawa")
                .dragAndDropeLeft(525, 0, "4 zł")
                .dragAndDropeRight(0, 0, "5 zł")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiPayByCard() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Złota 1, Warszawa", "Wałbrzyska 48, Warszawa")
                .choosePayByCardFiltr()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiZwierzeta() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Grzybowska 1, Warszawa", "Kijowska 1, Warszawa")
                .chooseZwierzetaFiltr()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiKombi() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Al. Jana Pawła II 24, Warszawa", "Gwiaździsta 2, Warszawa")
                .chooseKombiFiltr()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiFotelikDlaDziecka() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Ciepła 1, Warszawa", "Bródnowska 3, Warszawa")
                .chooseFotelikDlaDzieckaFiltr()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiKlimatyzacja() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Twarda 1, Warszawa", "Rondo Szala J., Warszawa")
                .chooseKlimatyzacjaFiltr()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiPrzesylka() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Nowogrodzka 3, Warszawa", "Radiowa 6, Warszawa")
                .choosePrzesylkaFiltr()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiZakupy() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Mokotowska 3, Warszawa", "Puławska 5, Warszawa")
                .chooseZakupyFiltr()
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiJezykAngielski() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Pańska 5, Warszawa", "Wrocławska 1A, Warszawa")
                .chooseJezykAngielskiFiltr()
                .saveOrder();
    }


    @org.testng.annotations.Test
    public void shouldOrderTaxiBus5persons() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Koszykowa 2, Warszawa", "Stawki 5, Warszawa")
                .chooseBusFiltr(5)
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiBus6persons() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Agrykola 1, Warszawa", "Przasnyska 5, Warszawa")
                .chooseBusFiltr(6)
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderTaxiBus7persons() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Sienna 4, Warszawa", "Cichy Potok 3, Warszawa")
                .chooseBusFiltr(7)
                .saveOrder();
    }


    @org.testng.annotations.Test
    public void shouldOrderTaxiBus8persons() throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Sienna 6, Warszawa", "Cichy Potok 5, Warszawa")
                .chooseBusFiltr(8)
                .addComment("panna anna")
                .addNote("a nic")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldCancelOrder () throws InterruptedException {
        new MakeOrderPage()
                .choseB2COrder()
                .cancelOrder();
    }

}

