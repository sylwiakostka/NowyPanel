package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;

public class B2BFutureTests extends TestConfig {


    @org.testng.annotations.Test
    public void shouldMakeOrderTodayPremiumVIP() throws Exception {
        new MakeOrderPage()
                .chooseB2BOrder()
                .introduceDanePracownika(5, 0)
                .introduceAddresses("Śliska 5, Warszawa", "Wałbrzyska 14, Warszawa")
                .choseLuxuryTaxi()
                .orderInXMinutes(21)
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldMakeOrderTodayAirpotr() throws Exception {
        new MakeOrderPage()
                .chooseB2BOrder()
                .introduceDanePracownika(4, 0)
                .introduceAddresses("Żwirki i Wigury 1, Warszawa", "Pańska 1, Warszawa")
                .addComment("królowa Sara")
                .orderInXMinutes(40)
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldMakeOrderTodayInMinutesMixFilters() throws Exception {
        new MakeOrderPage()
                .chooseB2BOrder()
                .introduceDanePracownika(5, 0)
                .introduceAddresses("Żwirki i Wigury 2, Warszawa", "Pańska 1, Warszawa")
                .choseLuxuryTaxi()
                .chooseJezykAngielskiFiltr()
                .chooseZakupyFiltr()
                .chooseKombiFiltr()
                .chooseBusFiltr(6)
                .chooseZwierzetaFiltr()
                .addComment("dużo bagaży + pies, od wejścia głównego")
                .orderInXMinutes(70)
                .saveOrder();

    }
}
