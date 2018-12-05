package NowyPanelPageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static NowyPanelPageObject.config.WebDriverSingleton.getInstance;

public class StarszaWersjaPaneluPage extends BasePage {
    public StarszaWersjaPaneluPage() {
        super();
    }

    @FindBy(xpath = "//input[@name = 'login']")
    private WebElement loginButton;

    public StarszaWersjaPaneluPage verifyStarszaWersjaPanelu() {

        for (String winHandle : getInstance().getWindowHandles()) {
            getInstance().switchTo().window(winHandle);
        }
        Assertions.assertTrue(loginButton.isDisplayed());
        return this;
    }


}
