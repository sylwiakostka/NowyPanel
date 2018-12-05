package NowyPanelPageObject.tests;

import NowyPanelPageObject.config.TestConfig;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.junit.jupiter.api.Test;
import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class TakeScreenshotsTest extends TestConfig {

    @Test
    public void takeScreenshotMakeOrderPage(){
        Shutterbug.shootPage(getInstance(), ScrollStrategy.BOTH_DIRECTIONS, 500, true).withName("MakeOrderPageScreen").save("C:\\Users\\user\\Documents\\TestyScreeny");
    }
}
