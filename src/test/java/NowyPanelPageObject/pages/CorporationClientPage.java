package NowyPanelPageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class CorporationClientPage extends BasePage {
    public CorporationClientPage() {
        super();
    }

    @FindBy(name = "login")
    private WebElement loginButton;


    public CorporationClientPage verifyCorporationClientPage() {
        for (String winHandle : getInstance().getWindowHandles()) {
            getInstance().switchTo().window(winHandle);
        }
        Assertions.assertTrue(loginButton.isDisplayed());
        return this;
    }
}