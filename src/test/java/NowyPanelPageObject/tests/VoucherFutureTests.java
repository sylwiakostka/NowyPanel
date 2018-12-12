package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;

public class VoucherFutureTests extends TestConfig {

    @org.testng.annotations.Test
    public void shouldOrderWithVoucherPracownik() throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(9, 0)
                .assertDanePracownika(9, 1)
                .assertDaneVouchera(9, 0)
                .introduceAddresses("Hynka F. 3, Warszawa", "Kielecka 2, Warszawa")
                .chooseJezykAngielskiFiltr()
                .chooseZakupyFiltr()
                .chooseKombiFiltr()
                .chooseBusFiltr(6)
                .chooseZwierzetaFiltr()
                .addNote("dużo bagaży + pies, od wejścia głównego")
                .orderInXMinutes(50)
                .saveOrder();

    }

    @org.testng.annotations.Test
    public void shouldOrderWithVoucherGosc () throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(10,0)
                .assertDanePracownika(10,1)
                .assertDaneVouchera(10,0)
                .introduceAddresses("Filtrowa 2, Warszawa", "Majowa 4, Warszawa")
                .orderInXMinutes(40)
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderWithNonameVoucher () throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(11,0)
                .assertDaneVouchera(11,0)
                .introduceAddressesAndFullName("Hoża 2, Warszawa","Chełmska 4, Warszawa")
                .orderInXMinutes(40)
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldCanNotOrderInSunday () throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(12,0)
                .selectOnlySundays()
                .verifyAlertDays()
                .cancelOrder();
    }

    @org.testng.annotations.Test
    public void shouldCanNotOrderBetween18And23 () throws Exception {
        new MakeOrderPage()
                .chooseInvalidHourVoucher()
                .cancelOrder();
    }
}
