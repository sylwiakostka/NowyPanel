package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;

public class VoucherNowTests extends TestConfig {

    @org.testng.annotations.Test
    public void shouldOrderWithVoucherPracownik() throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(1, 0)
                .assertDanePracownika(1, 1)
                .assertDaneVouchera(1, 0)
                .introduceAddresses("Piękna 2, Warszawa", "Rozłogi 1, Warszawa")
                .choseLuxuryTaxi()
                .chooseJezykAngielskiFiltr()
                .chooseZakupyFiltr()
                .chooseKombiFiltr()
                .chooseBusFiltr(6)
                .chooseZwierzetaFiltr()
                .addNote("dużo bagaży + pies, od wejścia głównego")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldNotOrderWithStaleVoucher() throws Exception {
        new MakeOrderPage()
                .chooseStaleVoucher(6, 0)
                .cancelOrder();
    }

    @org.testng.annotations.Test
    public void shouldOrderWithVoucherGosc() throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(2, 0)
                .assertDaneVouchera(2, 0)
                .introduceAddressesAndFullName("Polna 3, Warszawa", "Baranowska 1, Warszawa")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void deleteVoucher() throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(2, 0)
                .assertDaneVouchera(2, 0)
                .deleteVoucher();
    }

    @org.testng.annotations.Test
    public void shouldOrderWithNonameVoucher() throws Exception {
        new MakeOrderPage()
                .chooseCorrectVoucher(11, 0)
                .assertDaneVouchera(11, 0)
                .introduceAddressesAndFullName("Hoża 2, Warszawa", "Chełmska 4, Warszawa")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldInformAboutVoucherTarifLimit() throws Exception {
        new MakeOrderPage()
                .chooseMaxTariffLimitVoucher()
                .assertDaneVouchera(14, 0)
                .introduceAddressesAndFullName("Różana 3, Warszawa", "Hawajska 4, Warszawa")
                .saveOrder();
    }

    @org.testng.annotations.Test
    public void shouldInformAboutTaxiClassLimitVoucher() throws Exception {
        new MakeOrderPage()
                .choosePopularTaxiLimitVoucher()
                .assertDaneVouchera(15, 0)
                .introduceAddressesAndFullName("Uniwersytecka 4, Warszawa", "Twarda 3, Warszawa")
                .saveOrder();
    }

}