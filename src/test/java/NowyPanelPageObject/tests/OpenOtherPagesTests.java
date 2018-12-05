package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class OpenOtherPagesTests extends TestConfig {

    @Test
    public void openUserHistory() {
        new MakeOrderPage()
                .openUserHistory();
    }

    @Test
    public void openStarszaWersjaPanelu() {
        new MakeOrderPage()
                .openStarszaWersjaPanelu();
    }

    @Test
    public void zglosBlad() {
        new MakeOrderPage()
                .zglosBlad();
    }

    @Test
    public void openSesjePage() throws InterruptedException, AWTException {
        new MakeOrderPage()
                .openSesjePage();
    }

    @Test
    public void openStatystykiPage() throws InterruptedException, AWTException {
        new MakeOrderPage()
                .openStatystykiPage();
    }


    @Test
    public void openRaportyPage() throws InterruptedException, AWTException {
        new MakeOrderPage()
                .openRaportyPage();
    }

    @Test
    public void openMonitoringOdrzuconychZlecenPage() throws AWTException, InterruptedException {
        new MakeOrderPage()
                .openMonitoringOdrzuconychZlecenPage();
    }
}
