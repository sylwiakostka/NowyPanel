package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;
import org.junit.jupiter.api.Test;

public class VoucherTests extends TestConfig {

    @Test
    public void shouldOrderWithVoucherPracownik() throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(1,0)
                .introduceAddresses("Piękna 2, Warszawa", "Rozłogi 1, Warszawa")
                .assertDanePracownikaIVoucher(1,1, 1,0)
                .saveOrder();
    }

    @Test
    public void shouldNotOrderWithIncorrectVoucher () throws Exception {
        new MakeOrderPage()
                .chooseIncorrectVoucher(6,0)
                .cancelOrder();

    }

}