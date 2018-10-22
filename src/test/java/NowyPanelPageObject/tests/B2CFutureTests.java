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
                .introduceAddressesAndFullName("Towarowa 1, Warszawa", "Wałbrzyska 5, Warszawa")
                .orderIn20Minutes()
                .saveOrder();
    }

    @Test
    public void shouldOrderInOneHour() throws Exception {
        new MakeOrderPage()
                .choseB2COrder()
                .introduceAddressesAndFullName("Kolejowa 1, Warszawa", "Baśniowa 3, Warszawa")
                .orderInOneHour()
                .saveOrder();
    }

}
