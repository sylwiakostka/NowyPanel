package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;
import org.junit.jupiter.api.Test;

public class B2CFutureTests extends TestConfig {

    @Test
    public void shouldMakeBasicOrderToday() throws Exception {
        new MakeOrderPage()
                .choseB2COrder()
                .setHourAndMinute("16", "30")
                .introduceAddressesAndFullName("Śliska 5, Warszawa", "Wałbrzyska 14, Warszawa")
                .saveOrder();
    }

    @Test
    public void shouldOrderIn20Minutes() throws Exception {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Towarowa 5, Warszawa", "Wałbrzyska 5, Warszawa")
                .orderIn20Minutes()
                .saveOrder();
    }

    @Test
    public void shouldOrderInOneHour() throws Exception {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Żwirki i Wigury 1, Warszawa", "Baśniowa 3, Warszawa")
                .orderInOneHour()
                .saveOrder();
    }

    @Test
    public void shouldOrderToAirportToday () throws Exception {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Żwirki i Wigury 1, Warszawa", "Prosta 6, Warszawa")
                .orderInOneHour()
                .chooseJezykAngielskiFiltr()
                .chooseKombiFiltr()
                .addNote("duże walizki, francuzi")
                .saveOrder();
    }

    @Test
    public void shouldOrderTodayInXMinutes () throws Exception {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Łucka 4, Warszawa","Lazurowa, Warszawa" )
                .orderInXMinutes(40)
                .saveOrder();
    }

    @Test
    public void shouldOrderTaxiTodayInXMinutesMixFilters () throws Exception {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Al. Jana Pawła II 2, Warszawa", "Mickiewicza A. 4, Warszawa")
                .choseLuxuryTaxi()
                .chooseJezykAngielskiFiltr()
                .chooseZakupyFiltr()
                .chooseKombiFiltr()
                .chooseBusFiltr(6)
                .chooseZwierzetaFiltr()
                .addComment("dużo bagaży + pies, od wejścia głównego")
                .orderInXMinutes(22)
                .saveOrder();
    }

    @Test
    public void shouldOrderTaxiPayByCard () throws Exception {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Jasna 4, Warszawa", "Prosta 1, Warszawa")
                .choosePayByCardFiltr()
                .orderInXMinutes(20)
                .saveOrder();
    }



}
