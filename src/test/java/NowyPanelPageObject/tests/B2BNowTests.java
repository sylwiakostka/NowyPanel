package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;
import org.junit.jupiter.api.Test;

public class B2BNowTests extends TestConfig {

    @Test
    public void shouldMakeBasicOrder() throws Exception {
        new MakeOrderPage()
                .chooseB2BOrder()
                .introduceDanePracownika(1,0)
                .introduceAddresses("Wernyhory 13, Warszawa", "Jasna 6, Warszawa")
                .saveOrder();
    }

    @Test
    public void shouldOrderLuxuryTaxi () throws Exception {
        new MakeOrderPage()
                .chooseB2BOrder()
                .introduceDanePracownika(2,0)
                .introduceAddresses("Irysowa 4, Warszawa", "Jutrzenki 2, Warszawa")
                .choseLuxuryTaxi()
                .addNote("głowne wejscie")
                .saveOrder();
    }




}