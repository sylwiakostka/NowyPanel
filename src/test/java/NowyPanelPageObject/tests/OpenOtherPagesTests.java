package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;

import java.awt.*;

public class OpenOtherPagesTests extends TestConfig {

    @org.testng.annotations.Test
    public void openUserHistory() {
        new MakeOrderPage()
                .openUserHistory();
    }

    @org.testng.annotations.Test
    public void openStarszaWersjaPanelu() {
        new MakeOrderPage()
                .openStarszaWersjaPanelu();
    }

    @org.testng.annotations.Test
    public void zglosBlad() {
        new MakeOrderPage()
                .zglosBlad();
    }

    @org.testng.annotations.Test
    public void openSesjePage() throws InterruptedException, AWTException {
        new MakeOrderPage()
                .openSesjePage();
    }

    @org.testng.annotations.Test
    public void openStatystykiPage() throws InterruptedException, AWTException {
        new MakeOrderPage()
                .openStatystykiPage();
    }


    @org.testng.annotations.Test
    public void openRaportyPage() throws InterruptedException, AWTException {
        new MakeOrderPage()
                .openRaportyPage();
    }

    @org.testng.annotations.Test
    public void openMonitoringOdrzuconychZlecenPage() throws AWTException, InterruptedException {
        new MakeOrderPage()
                .openMonitoringOdrzuconychZlecenPage();
    }
}
