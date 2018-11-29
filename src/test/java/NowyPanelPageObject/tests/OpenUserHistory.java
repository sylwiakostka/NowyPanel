package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import NowyPanelPageObject.pages.MakeOrderPage;
import org.junit.jupiter.api.Test;

public class OpenUserHistory extends TestConfig {

    @Test
    public void openUserHistory () throws Exception {
        new MakeOrderPage()
                .openUserHistory()
                .verifyCorporationClientPage();
    }
}
