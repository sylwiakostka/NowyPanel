package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;
import org.junit.jupiter.api.Test;

public class VoucherTests extends TestConfig {

    @Test
    public void shouldOrderWithVoucherPracownik() throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(1,0)
                .assertDanePracownika(1,1)
                .assertDaneVouchera(1,0)
                .introduceAddresses("Piękna 2, Warszawa", "Rozłogi 1, Warszawa")
                .saveOrder();
    }

    @Test
    public void shouldNotOrderWithIncorrectVoucher () throws Exception {
        new MakeOrderPage()
                .chooseIncorrectVoucher(6,0)
                .cancelOrder();
    }

    @Test
    public void shouldOrderWithVoucherGosc () throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(2,0)
                .assertDaneVouchera(2,0)
                .introduceAddressesAndFullName("Polna 3, Warszawa", "Baranowska 1, Warszawa")
                .saveOrder();
    }


}