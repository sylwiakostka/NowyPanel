package NowyPanelPageObject.pages;

import org.junit.jupiter.api.Assertions;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class MonitoringOdrzuconychZlecenPage extends BasePage {
    public MonitoringOdrzuconychZlecenPage (){super ();}

    public MonitoringOdrzuconychZlecenPage verifyMonitoringOdrzuconychZlecenPage (){
        for (String winHandle : getInstance().getWindowHandles()) {
            getInstance().switchTo().window(winHandle);
        }
        String URL = getInstance().getCurrentUrl();
        Assertions.assertEquals("http://taxi2.demo.eo.pl/admin/recently-dismissed-orders", URL);
        return this;
    }
}
